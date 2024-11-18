package com.example.Spring.Data.Overview.service.guide;

import com.example.Spring.Data.Overview.dto.guide.GuideDto;
import com.example.Spring.Data.Overview.mapper.GuideMapper;
import com.example.Spring.Data.Overview.model.Guide;
import com.example.Spring.Data.Overview.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuideServiceImpl implements GuideService{

    @Autowired
    GuideRepository guideRepository;
    @Autowired
    GuideMapper guideMapper;

    @Override
    public GuideDto persistGuideAlongWithStudents(GuideDto guideDto) {

        Guide guide=guideMapper.convertToEntity(guideDto);
        guideRepository.save(guide);
        return  guideMapper.convertToDto(guideRepository.findById(guide.getGuideId()).get());
    }

    @Override
    public GuideDto updateGuide(String staffId) {
        return null;
    }

    @Override
    public GuideDto deleteGuide(String staffId) {
        return null;
    }

    @Override
    public List<GuideDto> getGuides() {
       List<Guide> list= guideRepository.findAll();
        return list.stream().map(guideMapper::convertToDto).collect(Collectors.toList());
    }
}
