package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "trackpoints",
        indexes = {@Index(name = "idx_time", columnList="time")})
public class TrackPoint implements Serializable {
    private static final long serialVersionUID = 7125106141306865292L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ele;

    private String lat;

    private String lon;

    private Date time;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name="track_id", referencedColumnName = "id")
    private Track track1;

    public TrackPoint() {
    }

    public TrackPoint(String ele, String lat, String lon, Date time, Date createDate, Date updatedDate, Track track1) {
        this.ele = ele;
        this.lat = lat;
        this.lon = lon;
        this.time = time;
        this.createdDate = createDate;
        this.updatedDate = updatedDate;
        this.track1 = track1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEle() {
        return ele;
    }

    public void setEle(String ele) {
        this.ele = ele;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createDate) {
        this.createdDate = createDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Track getTrack1() {
        return track1;
    }

    public void setTrack1(Track track1) {
        this.track1 = track1;
    }
}
