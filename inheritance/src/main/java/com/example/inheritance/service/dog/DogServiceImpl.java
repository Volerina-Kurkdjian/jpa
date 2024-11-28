package com.example.inheritance.service.dog;

import com.example.inheritance.dto.DogDto;
import com.example.inheritance.mapper.DogMapper;
import com.example.inheritance.model.Dog;
import com.example.inheritance.repository.DogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DogServiceImpl implements DogService{

    private final DogRepository dogRepository;
    private final DogMapper dogMapper;

    @Override
    @Transactional
    public DogDto createDog(DogDto dogDto) {

        Dog dog = dogMapper.toDogEntity(dogDto);
        Dog savedDog = dogRepository.save(dog);
        return dogMapper.toDogDto(savedDog);
    }


    @Override
    @Transactional(readOnly = true)
    public DogDto getDogById(Long id) {

        Dog dog = dogRepository.findById(id).get();
        return dogMapper.toDogDto(dog);
    }
}
