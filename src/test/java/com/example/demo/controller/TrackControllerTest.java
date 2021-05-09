package com.example.demo.controller;

import com.example.demo.Utilities.Constants;
import com.example.demo.common.GeneralApiResponse;
import com.example.demo.model.dto.MetadataDto;
import com.example.demo.model.dto.TrackDto;
import com.example.demo.service.gpx.TrackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TrackControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TrackService trackService;

	@Test
	public void uploadGpxFile_success() throws Exception{
		MockMultipartFile gpxFile = new MockMultipartFile("filename.gpx", "", "application/gpx+xm", "some xml".getBytes());
		GeneralApiResponse<Object> response = new GeneralApiResponse<>(Constants.STATUS_SUCCESS, Constants.SUCCESS);
		given(trackService.uploadGpxFile(any(MultipartFile.class))).willReturn(response);
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/track/upload")
				.file("gpxFile", gpxFile.getBytes())
				.characterEncoding("UTF-8"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("status").value(Constants.STATUS_SUCCESS))
				.andExpect(jsonPath("statusCode").value(Constants.SUCCESS));
	}

	@Test
	public void uploadGpxFile_invalid_file() throws Exception{
		MockMultipartFile jpegFile = new MockMultipartFile("filename.jpg", "", "application/gpx+xm", "some data".getBytes());
		GeneralApiResponse<Object> response = new GeneralApiResponse<>(Constants.STATUS_ERROR, Constants.INVALID_GPX_FILE);
		given(trackService.uploadGpxFile(any(MultipartFile.class))).willReturn(response);
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/track/upload")
				.file("gpxFile", jpegFile.getBytes())
				.characterEncoding("UTF-8"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("status").value(Constants.STATUS_ERROR))
				.andExpect(jsonPath("statusCode").value(Constants.INVALID_GPX_FILE));
	}

	@Test
	public void getTrackDetail_success()  throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TrackDto trackDto = new TrackDto(310L, new MetadataDto(320L, formatter.parse("2019-10-20 10:00:00")));
		GeneralApiResponse<TrackDto> response = new GeneralApiResponse<TrackDto>(Constants.STATUS_SUCCESS, Constants.SUCCESS,
				trackDto);
		given(trackService.getTrackDetail(any(Long.class))).willReturn(response);
		//when(trackService.getLatestTracks(any(Integer.class), any(Integer.class))).thenReturn(response); // mock t
		mockMvc.perform(get("/api/track/310")).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("status").value(Constants.STATUS_SUCCESS))
				.andExpect(jsonPath("statusCode").value(Constants.SUCCESS))
				.andExpect(jsonPath("$.result.id").value(310));
	}

	@Test
	public void getTrackDetail_not_found()  throws Exception{
		GeneralApiResponse<TrackDto> response = new GeneralApiResponse<TrackDto>(Constants.STATUS_ERROR, Constants.TRACK_NOT_FOUND);
		given(trackService.getTrackDetail(any(Long.class))).willReturn(response);
		mockMvc.perform(get("/api/track/999")).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("status").value("1"))
				.andExpect(jsonPath("statusCode").value(Constants.TRACK_NOT_FOUND));
	}

	@Test
	public void getLatestTracks() throws Exception {

		List<TrackDto> resultList = new ArrayList<TrackDto>(){{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			add(new TrackDto(311L, new MetadataDto(321L, formatter.parse("2021-04-12 21:15:21"))));
			add(new TrackDto(310L, new MetadataDto(320L, formatter.parse("2019-10-20 10:00:00"))));
			add(new TrackDto(312L, new MetadataDto(322L, formatter.parse("2017-10-22 09:41:33"))));
		}};
		Pageable pageable = new PageRequest(0, 10);
		GeneralApiResponse<Page<TrackDto>> response = new GeneralApiResponse<Page<TrackDto>>(Constants.STATUS_SUCCESS, Constants.SUCCESS,
				new PageImpl<>(resultList, pageable, 3));
		when(trackService.getLatestTracks(any(Integer.class), any(Integer.class))).thenReturn(response); // mock t
		mockMvc.perform(get("/api/track/latest")).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("status").value("0"))
				.andExpect(jsonPath("statusCode").value("success"))
				.andExpect(jsonPath("$.result.content.length()").value(3))
				.andExpect(jsonPath("$.result.content[0].id").value(311));
	}


}
