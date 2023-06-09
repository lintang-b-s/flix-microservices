package com.lintang.netflik.movieservice.helper.entityMapper;

import com.lintang.netflik.movieservice.dto.AddVideoReq;
import com.lintang.netflik.movieservice.dto.Video;
import com.lintang.netflik.movieservice.entity.MovieEntity;
import com.lintang.netflik.movieservice.entity.VideoEntity;
import org.springframework.stereotype.Component;

@Component
public class VideoEntityMapper {
    public VideoEntity saveEntity(AddVideoReq videoDto) {
        VideoEntity entity = new VideoEntity();
        return entity.setUrl(videoDto.getUrl())
                .setLength(videoDto.getLength()) .setTitle(videoDto.getTitle()).setSynopsis(videoDto.getSynopsis());
    }

    public VideoEntity toEntity(AddVideoReq videoDto, MovieEntity movie) {
        VideoEntity entity = new VideoEntity();
        movie.setId(videoDto.getMovieId());
        return entity.setUrl(videoDto.getUrl())
                .setLength(videoDto.getLength()) .setTitle(videoDto.getTitle()).setSynopsis(videoDto.getSynopsis())
                .setMovie(movie);

    }

    public VideoEntity videoDtoToEntity(Video video, MovieEntity movie) {
        VideoEntity entity = new VideoEntity();
        return entity.setId(video.getId()).setSynopsis(video.getSynopsis()).setLength(video.getLength())
                .setTitle(video.getTitle()).setUrl(video.getUrl());

    }
}
