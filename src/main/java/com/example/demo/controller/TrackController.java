package com.example.demo.controller;

import com.example.demo.common.GeneralApiResponse;
import com.example.demo.model.dto.TrackDto;
import com.example.demo.service.gpx.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/track")
public class TrackController {
    private final TrackService gpxService;

    @Autowired
    public TrackController(TrackService gpxService){
        this.gpxService = gpxService;
    }
    @PostMapping("/upload")
    GeneralApiResponse<Object> uploadGpxFile(@RequestParam("gpxFile") MultipartFile gpxFile) {
        return gpxService.uploadGpxFile(gpxFile);
    }

    @GetMapping("/latest")
    GeneralApiResponse<Page<TrackDto>> getLatestTracks(@RequestParam(name = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return gpxService.getLatestTracks(pageIndex, pageSize);
    }

    @GetMapping("/{trackId}")
    GeneralApiResponse<TrackDto> getTrackDetail(@PathVariable("trackId") Long trackId) {
        return gpxService.getTrackDetail(trackId);
    }

}
