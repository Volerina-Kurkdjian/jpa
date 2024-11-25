package com.example.many_to_one.service.guide;

import com.example.many_to_one.dto.GuideDto;

import java.util.List;

public interface GuideService {

    GuideDto persistGuideAlongWithStudents(GuideDto guideDto);

    GuideDto updateGuide(GuideDto guideDto);

    GuideDto deleteGuide(Long id);

    List<GuideDto> getGuides();

    GuideDto getGuide(Long id);
}
