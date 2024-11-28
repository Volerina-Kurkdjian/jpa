package com.example.inheritance.mapper;

import com.example.inheritance.dto.CatDto;
import com.example.inheritance.model.Cat;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CatMapper {

     private ModelMapper modelMapper;

     public CatDto toCatDto(Cat cat) {
         CatDto catDto = modelMapper.map(cat, CatDto.class);
         return catDto;
     }

     public Cat toCatEntity(CatDto catDto) {
         Cat cat = modelMapper.map(catDto, Cat.class);
         return cat;
     }
}
