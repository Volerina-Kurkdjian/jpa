package com.example.many.to.many.service.actor;

import com.example.many.to.many.dto.ActorDto;

public interface ActorService {

    ActorDto createActor(Long movieId,ActorDto actorDto);

    ActorDto updateActor(ActorDto actorDto);

}
