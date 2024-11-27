package com.example.many.to.many.service.movie;

import com.example.many.to.many.dto.MovieDto;
import com.example.many.to.many.entity.Movie;
import com.example.many.to.many.entity.Actor;
import com.example.many.to.many.mapper.MovieMapper;
import com.example.many.to.many.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto createMovie(MovieDto movieDto) {

        Movie movie = movieMapper.mapToEntity(movieDto);
        Movie savedMovie = movieRepository.save(movie);

        return movieMapper.mapToDto(savedMovie);
    }

    @Override
    public MovieDto updateMovie(MovieDto movieDto) {
        return null;
    }
}
