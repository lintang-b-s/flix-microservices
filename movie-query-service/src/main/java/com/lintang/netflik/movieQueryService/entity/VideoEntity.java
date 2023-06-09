package com.lintang.netflik.movieQueryService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document("videos")
public class VideoEntity {
    @Id
    private int id;

    private String url;

    private int length;

    private String title;

    private String synopsis;

    @DocumentReference(lazy = true)
    private MovieEntity movie;

    public int getId() {
        return id;
    }

    public VideoEntity setId(int id) {
        this.id = id;
        return this;
    }


    public String getUrl() {
        return url;
    }

    public VideoEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getLength() {
        return length;
    }

    public VideoEntity setLength(int length) {
        this.length = length;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public VideoEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public VideoEntity setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }


    public MovieEntity getMovie() {
        return movie;
    }

    public VideoEntity setMovie(MovieEntity movie) {
        this.movie = movie;
        return this;
    }

    public void addMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public void removeMovie(MovieEntity movie) {
        this.movie = null;
    }


    @Override
    public String toString() {
        return "VideoEntity{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", length=" + length +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", movie=" + movie +
                '}';
    }
}
