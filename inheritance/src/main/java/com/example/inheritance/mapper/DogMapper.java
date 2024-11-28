package com.example.inheritance.mapper;

import com.example.inheritance.dto.DogDto;
import com.example.inheritance.model.Dog;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DogMapper {


    private ModelMapper modelMapper;

    public DogDto toDogDto(Dog dog) {

        DogDto dogDto = modelMapper.map(dog, DogDto.class);
        return dogDto;
    }

    public Dog toDogEntity(DogDto dogDto) {

        Dog dog = modelMapper.map(dogDto, Dog.class);
        return dog;
    }
}
