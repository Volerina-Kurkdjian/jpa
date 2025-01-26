package com.example.books;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookMapper {

    @Autowired
     ModelMapper modelMapper;


    public BookDto bookDto(BookEntity bookEntity){
        BookDto bookDto=modelMapper.map(bookEntity,BookDto.class);
        return  bookDto;
    }

    public BookEntity bookEntity(BookDto bookDto){
        return modelMapper.map(bookDto,BookEntity.class);
    }
}
