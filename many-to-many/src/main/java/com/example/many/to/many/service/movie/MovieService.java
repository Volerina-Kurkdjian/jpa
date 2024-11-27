package com.example.many.to.many.service.movie;

import com.example.many.to.many.dto.MovieDto;

public interface MovieService {

    MovieDto createMovie(MovieDto movieDto);
    MovieDto updateMovie(MovieDto movieDto);

}
