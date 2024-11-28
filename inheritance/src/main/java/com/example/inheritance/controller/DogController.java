package com.example.inheritance.controller;

import com.example.inheritance.dto.DogDto;
import com.example.inheritance.service.dog.DogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dog")
@AllArgsConstructor
public class DogController {

    private final DogService dogService;

    @PostMapping
    public ResponseEntity<DogDto> createDog(@RequestBody DogDto dogDto) {

        DogDto savedDog = dogService.createDog(dogDto);
        return new ResponseEntity<>(savedDog, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DogDto> getDogById(@PathVariable Long id) {
        DogDto dogDto = dogService.getDogById(id);
        return new ResponseEntity<>(dogDto, HttpStatus.OK);
    }
}
