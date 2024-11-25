package com.example.many_to_one.mapper;

import com.example.many_to_one.dto.StudentDto;
import com.example.many_to_one.entity.Student;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    @Autowired
    ModelMapper modelMapper;


    public Student toEntity(StudentDto studentDto){
        Student student=modelMapper.map(studentDto,Student.class);
        return student;
    }

    public StudentDto toStudentDto(Student student){
        StudentDto studentDto=modelMapper.map(student, StudentDto.class);
        return studentDto;
    }
}
