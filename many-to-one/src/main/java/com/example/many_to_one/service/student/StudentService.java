package com.example.many_to_one.service.student;

import com.example.many_to_one.dto.StudentDto;

public interface StudentService {

    StudentDto saveStudent(StudentDto student);

    StudentDto updateStudent(Long id,StudentDto studentDto);

}
