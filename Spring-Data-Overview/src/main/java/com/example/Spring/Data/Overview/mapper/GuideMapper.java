package com.example.Spring.Data.Overview.mapper;


import com.example.Spring.Data.Overview.dto.guide.GuideDto;
import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.model.Guide;
import com.example.Spring.Data.Overview.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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

         Set<StudentDto> studentDtoSet = new HashSet<>();
         for (Student student : guide.getStudentList()) {
             StudentDto studentDto = studentMapper.convertStudentToDto(student);
             studentDtoSet.add(studentDto);
         }

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

        Set<Student> studentSet = new HashSet<>();
        for (StudentDto studentDto : guideDto.getStudentList()) {
            Student student = studentMapper.convertDtoToStudent(studentDto);
            studentSet.add(student);
        }


        guide.setStudentList(studentSet);
        return guide;
    }
}
