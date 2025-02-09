package com.study.netflix.movie;

import com.study.netflix.movie.response.PageableMovieResponse;

public interface FetchMovieUseCase {
    PageableMovieResponse fetchFromClient(int page);
}
