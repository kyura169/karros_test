package com.example.demo.service.gpx;

import com.example.demo.common.GeneralApiResponse;
import com.example.demo.model.dto.TrackDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface TrackService {
	GeneralApiResponse<Object> uploadGpxFile(MultipartFile gpxFile);

	GeneralApiResponse<Page<TrackDto>> getLatestTracks(Integer pageIndex, Integer pageSize);

	GeneralApiResponse<TrackDto> getTrackDetail(Long trackId);
}
