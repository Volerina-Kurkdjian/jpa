package com.example.Spring.Data.Overview.mapper;


import com.example.Spring.Data.Overview.dto.guide.GuideDto;
import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.model.Guide;
import com.example.Spring.Data.Overview.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GuideMapper {

    @Autowired
    StudentMapper studentMapper;

     public GuideDto convertToDto(Guide guide) {

         if (guide == null) {
             throw new IllegalArgumentException("Guide must not be null");
         }

     // Convert Set<Student> to Set<StudentDto>
     Set<StudentDto> studentDtoSet = guide.getStudentList().stream() .map(studentMapper::convertStudentToDto).collect(Collectors.toSet());


         return GuideDto.builder() .staffId(guide.getStaffId())
                 .name(guide.getName())
                 .salary(guide.getSalary())
                 .studentList(studentDtoSet)
                 .build();
    }

    public Guide convertToEntity(GuideDto guideDto) {
        if (guideDto == null) {
            throw new IllegalArgumentException("GuideDto must not be null");
        }
        Guide guide = new Guide();
        guide.setStaffId(guideDto.getStaffId());
        guide.setName(guideDto.getName());
        guide.setSalary(guideDto.getSalary());

        // Convert Set<StudentDto> to Set<Student>
        Set<Student> studentSet = guideDto.getStudentList().stream().map(studentMapper::convertDtoToStudent).collect(Collectors.toSet());

        guide.setStudentList(studentSet);
        return guide;
    }
}
