package com.example.Spring.Data.Overview.service.guide;

import com.example.Spring.Data.Overview.dto.guide.GuideDto;

import java.util.List;

public interface GuideService {

    GuideDto persistGuideAlongWithStudents(GuideDto guideDto);

    GuideDto updateGuide(String staffId);

    GuideDto deleteGuide(String staffId);

    List<GuideDto> getGuides();

    GuideDto getGuide(Long id);

    GuideDto getGuideSecond(Long id);
}
