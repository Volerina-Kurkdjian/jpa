package com.example.many.to.many.controller;

import com.example.many.to.many.dto.ActorDto;
import com.example.many.to.many.service.actor.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actor")
@AllArgsConstructor
public class ActorController {

     private final ActorService actorService;

     @PostMapping("/create/{movieId}")
     public ResponseEntity<ActorDto> createActor(@PathVariable Long movieId, @RequestBody ActorDto actorDto)
        {
            ActorDto savedActor = actorService.createActor(movieId,actorDto);
            return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
        }
}
