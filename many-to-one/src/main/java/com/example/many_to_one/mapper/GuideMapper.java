package com.example.many_to_one.mapper;

import com.example.many_to_one.dto.GuideDto;
import com.example.many_to_one.dto.StudentDto;
import com.example.many_to_one.entity.Student;
import com.example.many_to_one.entity.Guide;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GuideMapper {

    @Autowired
    ModelMapper modelMapper;

    private final StudentMapper studentMapper;

    public  GuideDto toGuideDto(Guide guide){
        GuideDto guideDto=modelMapper.map(guide, GuideDto.class);
        Set<StudentDto> studentDtos = guide.getStudents().stream() .map(studentMapper::toStudentDto) .collect(Collectors.toSet());
        guideDto.setStudents(studentDtos);
        return guideDto;
    }

    public  Guide toGuideEntity(GuideDto guideDto){
        Guide guide=modelMapper.map(guideDto,Guide.class);
        Set<Student> students = guideDto.getStudents().stream() .map(studentMapper::toEntity) .collect(Collectors.toSet());
        guide.setStudents(students);
        return guide;
    }
}
