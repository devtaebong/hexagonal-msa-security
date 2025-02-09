package com.study.netflix.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TmdbResponse {
    private TmdbDateResponse dates;

    private String page;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("total_results")
    private int totalResults;

    private List<TmdbMovieNowPlaying> results;
}
