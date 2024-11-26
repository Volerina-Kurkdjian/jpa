package com.example.many_to_one.service.student;

import com.example.many_to_one.dto.StudentDto;
import com.example.many_to_one.entity.Student;

import java.util.List;

public interface StudentService {

    StudentDto saveStudent(StudentDto student);

    StudentDto updateStudent(Long id,StudentDto studentDto);

    List<StudentDto> getStudents(Integer age);

}
