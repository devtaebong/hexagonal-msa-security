package com.study.netflix.movie;

import lombok.Getter;

import java.util.List;

@Getter
public class TmdbPageableMovie {
    private final List<TmdbMovie> tmdbMovies;
    private final int page;
    private final boolean hasNext;

    public TmdbPageableMovie(List<TmdbMovie> tmdbMovies, int page, boolean hasNext) {
        this.tmdbMovies = tmdbMovies;
        this.page = page;
        this.hasNext = hasNext;
    }
}
