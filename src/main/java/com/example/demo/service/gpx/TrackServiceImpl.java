package com.example.demo.service.gpx;

import com.example.demo.Utilities.Constants;
import com.example.demo.Utilities.Util;
import com.example.demo.common.GeneralApiResponse;
import com.example.demo.entity.MetaData;
import com.example.demo.entity.Track;
import com.example.demo.entity.TrackPoint;
import com.example.demo.entity.WayPoint;
import com.example.demo.model.dto.TrackDto;
import com.example.demo.model.jaxb.*;
import com.example.demo.repository.MetaDataRepository;
import com.example.demo.repository.TrackPointRepository;
import com.example.demo.repository.TrackRepository;
import com.example.demo.repository.WayPointRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackServiceImpl implements TrackService {
	private final TrackRepository trackRepository;
	private final MetaDataRepository metaDataRepository;
	private final WayPointRepository wayPointRepository;
	private final TrackPointRepository trackPointRepository;

	@Autowired
	public TrackServiceImpl(TrackRepository trackRepository, MetaDataRepository metaDataRepository, WayPointRepository wayPointRepository,
							TrackPointRepository trackPointRepository) {
		this.trackRepository = trackRepository;
		this.metaDataRepository = metaDataRepository;
		this.wayPointRepository = wayPointRepository;
		this.trackPointRepository = trackPointRepository;
	}

	@Override
	public GeneralApiResponse<Object> uploadGpxFile(MultipartFile gpxFile) {
		if(!Util.validateGpxFile(gpxFile)) {
			return new GeneralApiResponse<>(Constants.STATUS_ERROR, Constants.INVALID_GPX_FILE);
		}
		GpxType gpx = null;
		try {
			JAXBContext jc = JAXBContext.newInstance("com.example.demo.model.jaxb");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			File convertedFile = Util.convertMultipartFile(gpxFile);
			JAXBElement<GpxType> root = (JAXBElement<GpxType>)unmarshaller
					.unmarshal(convertedFile);
			gpx = root.getValue();
		} catch(JAXBException | IOException ex) {
			return new GeneralApiResponse<>(Constants.STATUS_ERROR, Constants.PARSE_GPX_FILE_FAILED);
		}
		return storeGpxInformation(gpx);
	}

	@Override
	public GeneralApiResponse<Page<TrackDto>> getLatestTracks(Integer pageIndex, Integer pageSize) {
		Pageable pageable = new PageRequest(pageIndex -1, pageSize);
		Page<Track> result = trackRepository.findAllByOrderByMetaDataTimeDesc(pageable);
		List<TrackDto> dtoResult = new ArrayList<>();
		if(result.hasContent()) {
			dtoResult = result.getContent().stream().map(
					entity -> new ModelMapper().map(entity, TrackDto.class)).collect(Collectors.toList());
		}
		return new GeneralApiResponse<>(Constants.STATUS_SUCCESS, Constants.SUCCESS, new PageImpl<>(dtoResult, pageable, result.getTotalElements()));
	}

	@Override
	public GeneralApiResponse<TrackDto> getTrackDetail(Long trackId) {
		Track track = trackRepository.findOne(trackId);
		if(track == null) {
			return new GeneralApiResponse<>(Constants.STATUS_ERROR, Constants.TRACK_NOT_FOUND);
		}
		return new GeneralApiResponse<>(Constants.STATUS_SUCCESS, Constants.SUCCESS, new ModelMapper().map(track, TrackDto.class));
	}


	private GeneralApiResponse<Object> storeGpxInformation(GpxType gpxType) {
		Date now = new Date();
		Track track = new Track(gpxType.getTrk() != null ? gpxType.getTrk().getName() : "",
				gpxType.getTrk() != null ? gpxType.getTrk().getDesc() : "",
				gpxType.getVersion(), gpxType.getCreator(), now, now);
		trackRepository.save(track);
		MetadataType metadataType = gpxType.getMetadata();
		boolean isTrackPointListExisted = gpxType.getTrk() != null && gpxType.getTrk().getTrkseg() != null &&
				!CollectionUtils.isEmpty(gpxType.getTrk().getTrkseg().getTrkpt());
		//Check if metadata time is null, using the first track point time
		Date trackDate = Util.dateFromString(metadataType.getTime(), Constants.DATE_FORMAT);
		if(trackDate == null && isTrackPointListExisted) {
			trackDate = Util.dateFromString(gpxType.getTrk().getTrkseg().getTrkpt().get(0).getTime(), Constants.DATE_FORMAT);
		}
		MetaData metaData = new MetaData(metadataType.getName(), metadataType.getDesc(),metadataType.getAuthor(),
				metadataType.getLink() != null ? metadataType.getLink().getText() : "",
				metadataType.getLink() != null ? metadataType.getLink().getHref() : "",
				trackDate, now, now, track);
		metaDataRepository.save(metaData);
		if(!CollectionUtils.isEmpty(gpxType.getWpt())) {
			List<WayPoint> wayPoints = gpxType.getWpt().parallelStream().map(wpt -> new WayPoint(wpt.getName(), wpt.getSym(),
					wpt.getLat(),wpt.getLon(), now, now, track)).collect(Collectors.toList());
			wayPointRepository.save(wayPoints);
		}
		if(gpxType.getTrk() != null && gpxType.getTrk().getTrkseg() != null &&
		!CollectionUtils.isEmpty(gpxType.getTrk().getTrkseg().getTrkpt())) {
			List<TrackPoint> trackPoints = gpxType.getTrk().getTrkseg().getTrkpt().parallelStream().map(trkpt -> new TrackPoint(
						trkpt.getEle(), trkpt.getLat(), trkpt.getLon(),
						Util.dateFromString(trkpt.getTime(), Constants.DATE_FORMAT), now, now, track))
						.sorted(Comparator.comparing(TrackPoint::getTime, Comparator.nullsFirst(Comparator.naturalOrder()))).collect(Collectors.toList());
			trackPointRepository.save(trackPoints);
		}
		return new GeneralApiResponse<>(Constants.STATUS_SUCCESS, Constants.SUCCESS);
	}
}
