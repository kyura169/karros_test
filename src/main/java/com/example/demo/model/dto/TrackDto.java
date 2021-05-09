package com.example.demo.model.dto;


import com.example.demo.entity.WayPoint;

import javax.persistence.Column;
import java.util.Date;
import java.util.Set;

public class TrackDto {
    private Long id;
    private String name;
    private String description;
    private String version;
    private String creator;
    private MetadataDto metaData;
    private Set<WayPointDto> wayPoints;
    private Set<TrackPointDto> trackPoints;
    private Date createdDate;

    public TrackDto() {
    }

    public TrackDto(Long id, MetadataDto metaData) {
        this.id = id;
        this.metaData = metaData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public MetadataDto getMetaData() {
        return metaData;
    }

    public void setMetaData(MetadataDto metaData) {
        this.metaData = metaData;
    }

    public Set<WayPointDto> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(Set<WayPointDto> wayPoints) {
        this.wayPoints = wayPoints;
    }

    public Set<TrackPointDto> getTrackPoints() {
        return trackPoints;
    }

    public void setTrackPoints(Set<TrackPointDto> trackPoints) {
        this.trackPoints = trackPoints;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
