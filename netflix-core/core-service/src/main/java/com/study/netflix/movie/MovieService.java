package com.study.netflix.movie;

import com.study.netflix.movie.response.MovieResponse;
import com.study.netflix.movie.response.PageableMovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService implements FetchMovieUseCase {
    private final TmdbMoviePort tmdbMoviePort;

    @Override
    public PageableMovieResponse fetchFromClient(int page) {
        TmdbPageableMovie tmdbPageableMovie = tmdbMoviePort.fetchPageable(page);
        return new PageableMovieResponse(
                tmdbPageableMovie.getTmdbMovies().stream()
                        .map(movie -> new MovieResponse(
                                        movie.getMovieName(),
                                        movie.getIsAdult(),
                                        movie.getGenre(),
                                        movie.getOverview(),
                                        movie.getReleaseAt()
                                )
                        ).collect(Collectors.toList()),
                tmdbPageableMovie.getPage(),
                tmdbPageableMovie.isHasNext()
        );
    }
}
