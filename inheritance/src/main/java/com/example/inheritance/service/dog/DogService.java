package com.example.inheritance.service.dog;

import com.example.inheritance.dto.DogDto;
import com.example.inheritance.model.Dog;

public interface DogService {

    DogDto createDog(DogDto dogDto);
    DogDto getDogById(Long id);
}
