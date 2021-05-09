package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tracks")
public class Track implements Serializable {
    private static final long serialVersionUID = 4257858067973957207L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String version;

    private String creator;

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @OneToOne(mappedBy = "track2")
    private MetaData metaData;

    @OneToMany(mappedBy="track")
    private Set<WayPoint> wayPoints;

    @OneToMany(mappedBy="track1")
    private Set<TrackPoint> trackPoints;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    public Track() {
    }

    public Track(String version, String creator, Date createDate, Date updatedDate) {
        this.version = version;
        this.creator = creator;
        this.createdDate = createDate;
        this.updatedDate = updatedDate;
    }

    public Track(String name, String description, String version, String creator, Date createDate, Date updatedDate) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.creator = creator;
        this.createdDate = createDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Set<WayPoint> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(Set<WayPoint> wayPoints) {
        this.wayPoints = wayPoints;
    }

    public Set<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void setTrackPoints(Set<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
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
}
