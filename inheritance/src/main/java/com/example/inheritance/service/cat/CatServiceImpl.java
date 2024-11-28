package com.example.inheritance.service.cat;

import com.example.inheritance.dto.CatDto;
import com.example.inheritance.mapper.CatMapper;
import com.example.inheritance.model.Cat;
import com.example.inheritance.repository.CatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CatServiceImpl implements CatService{

    private final CatRepository catRepository;
    private final CatMapper catMapper;


    @Override
    @Transactional
    public CatDto createCat(CatDto catDto) {
        Cat cat = catMapper.toCatEntity(catDto);
        Cat savedCat = catRepository.save(cat);

        return catMapper.toCatDto(savedCat);
    }

    @Override
    @Transactional(readOnly = true)
    public CatDto getCatById(Long id) {
        Cat cat = catRepository.findById(id).get();
        return catMapper.toCatDto(cat);

    }
}
