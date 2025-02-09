package com.study.netflix.movie;

import com.study.netflix.movie.response.PageableMovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final FetchMovieUseCase fetchMovieUseCase;

    @GetMapping("/api/v1/movie/client/{page}")
    public PageableMovieResponse fetchMoviePageable(@PathVariable int page) {
        return fetchMovieUseCase.fetchFromClient(page);
    }
}
