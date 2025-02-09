package com.study.netflix.movie;

public interface TmdbMoviePort {
    TmdbPageableMovie fetchPageable(int page);
}
