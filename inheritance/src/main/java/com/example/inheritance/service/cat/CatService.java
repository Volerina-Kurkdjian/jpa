package com.example.inheritance.service.cat;

import com.example.inheritance.dto.CatDto;

public interface CatService {

    CatDto createCat(CatDto catDto);
    CatDto getCatById(Long id);
}
