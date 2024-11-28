package com.example.inheritance.controller;

import com.example.inheritance.dto.CatDto;
import com.example.inheritance.service.cat.CatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cat")
@AllArgsConstructor
public class CatController {

     private final CatService catService;

    @PostMapping
    public ResponseEntity<CatDto> createCat(@RequestBody CatDto catDto) {

        CatDto savedCat = catService.createCat(catDto);
        return new ResponseEntity<>(savedCat, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CatDto> getCatById(@PathVariable Long id) {

        CatDto catDto = catService.getCatById(id);
        return new ResponseEntity<>(catDto, HttpStatus.OK);
    }
}
