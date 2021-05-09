package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "metadatas")
public class MetaData implements Serializable {
    private static final long serialVersionUID = -6075016820288411467L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private String author;

    @Column(name = "link_text")
    private String linkText;

    @Column(name = "link_href")
    private String linkHref;

    private Date time;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToOne
    @JoinColumn(name = "track_id", referencedColumnName = "id")
    private Track track2;

    public MetaData() {
    }

    public MetaData(String name, String desc, String author, String linkText, String linkHref, Date time, Date createDate, Date updatedDate, Track track) {
        this.name = name;
        this.description = desc;
        this.author = author;
        this.linkText = linkText;
        this.linkHref = linkHref;
        this.time = time;
        this.createdDate = createDate;
        this.updatedDate = updatedDate;
        this.track2 = track;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getLinkHref() {
        return linkHref;
    }

    public void setLinkHref(String linkHref) {
        this.linkHref = linkHref;
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

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Track getTrack() {
        return track2;
    }

    public void setTrack(Track track) {
        this.track2 = track;
    }
}
