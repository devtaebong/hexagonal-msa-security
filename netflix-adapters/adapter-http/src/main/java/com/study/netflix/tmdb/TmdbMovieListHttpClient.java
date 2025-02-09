package com.study.netflix.tmdb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.netflix.client.TmdbHttpClient;
import com.study.netflix.movie.TmdbMovie;
import com.study.netflix.movie.TmdbMoviePort;
import com.study.netflix.movie.TmdbPageableMovie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class TmdbMovieListHttpClient implements TmdbMoviePort {
    @Value("${tmdb.api.movie-lists.now-playing}")
    private String nowPlayingUrl;
    private final TmdbHttpClient tmdbHttpClient;

    @Override
    public TmdbPageableMovie fetchPageable(int page) {
        String url = nowPlayingUrl + "?language=ko-KR&page" + page;
        String request = tmdbHttpClient.request(url, HttpMethod.GET, CollectionUtils.toMultiValueMap(Map.of()), Map.of());
        TmdbResponse response;
        try {
            response = new ObjectMapper().readValue(request, TmdbResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new TmdbPageableMovie(response.getResults().stream().map(movie -> new TmdbMovie(movie.getTitle(), movie.getAdult(), movie.getGenreIds(), movie.getOverview(), movie.getReleaseDate())).toList(),
                response.getTotalPages(),
                response.getTotalPages() - page != 0);
    }
}
