package com.example.many.to.many.mapper;

import com.example.many.to.many.dto.ActorDto;
import com.example.many.to.many.dto.MovieDto;
import com.example.many.to.many.entity.Actor;
import com.example.many.to.many.entity.Movie;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ActorMapper {


    ModelMapper modelMapper;
//    MovieMapper movieMapper;
//
//
//    public ActorDto maptToDto(Actor actor){
//        ActorDto actorDto=modelMapper.map(actor,ActorDto.class);
//        Set<MovieDto> movieDtos= actor.getMovies().stream().map(movieMapper::mapToDto).collect(Collectors.toSet());
//        actorDto.setMovies(movieDtos);
//        return modelMapper.map(actor,ActorDto.class);
//    }
//
//    public Actor mapToEntity(ActorDto actorDto){
//        Actor actor=modelMapper.map(actorDto,Actor.class);
//        Set<Movie> movies=actorDto.getMovies().stream().map(movieMapper::mapToEntity).collect(Collectors.toSet());
//        actor.setMovies(movies);
//        return actor;
//    }

    public ActorDto maptToDto(Actor actor) {
        ActorDto actorDto = modelMapper.map(actor, ActorDto.class);
        Set<MovieDto> movieDtos = actor.getMovies().stream() .map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toSet()); actorDto.setMovies(movieDtos); return actorDto;
    }

    public Actor mapToEntity(ActorDto actorDto) {
        Actor actor = modelMapper.map(actorDto, Actor.class);
        Set<Movie> movies = actorDto.getMovies().stream()
                .map(movieDto -> modelMapper.map(movieDto, Movie.class))
                .collect(Collectors.toSet());
        actor.setMovies(movies); return actor;
    }

}
