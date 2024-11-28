package com.example.many.to.many.service.actor;

import com.example.many.to.many.dto.ActorDto;
import com.example.many.to.many.dto.MovieDto;
import com.example.many.to.many.entity.Actor;
import com.example.many.to.many.entity.Movie;
import com.example.many.to.many.mapper.ActorMapper;
import com.example.many.to.many.mapper.MovieMapper;
import com.example.many.to.many.repository.ActorRepository;
import com.example.many.to.many.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService{

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;


        @Transactional
        @Override
        public ActorDto createActor(Long movieId,ActorDto actorDto) {

            Movie movie = movieRepository.findById(movieId).get();
            Actor actor = actorMapper.mapToEntity(actorDto);

            // Add and create new Actor
            Actor savedActor = actorRepository.save(actor);
            movie.getActors().add(actor);

            return actorMapper.maptToDto(savedActor);
        }

        @Override
        public ActorDto updateActor(ActorDto actorDto) {
            return null;
        }
}
