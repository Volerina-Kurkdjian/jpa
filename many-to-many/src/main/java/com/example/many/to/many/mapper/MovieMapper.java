package com.example.many.to.many.mapper;

import com.example.many.to.many.dto.MovieDto;
import com.example.many.to.many.dto.ActorDto;
import com.example.many.to.many.entity.Movie;
import com.example.many.to.many.entity.Actor;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MovieMapper {


    private final ModelMapper modelMapper;
    public MovieDto mapToDto(Movie movie) {
        MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
        Set<ActorDto> actorDtos = movie.getActors().stream() .map(actor -> modelMapper.map(actor, ActorDto.class))
                .collect(Collectors.toSet());
        movieDto.setActors(actorDtos);
        return movieDto;
    }

    public Movie mapToEntity(MovieDto movieDto) {
        Movie movie = modelMapper.map(movieDto, Movie.class);
        Set<Actor> actors = movieDto.getActors().stream()
                .map(actorDto -> modelMapper.map(actorDto, Actor.class))
                .collect(Collectors.toSet());
        movie.setActors(actors);
        return movie;
    }
}
