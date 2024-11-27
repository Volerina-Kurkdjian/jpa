package com.example.many.to.many.controller;

import com.example.many.to.many.dto.MovieDto;
import com.example.many.to.many.service.movie.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDto> saveMovie(@RequestBody MovieDto movieDto) {
     MovieDto savedMovie = movieService.createMovie(movieDto);
     return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);

    }
}
