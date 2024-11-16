package com.example.Spring.Data.Overview.mapper;

import com.example.Spring.Data.Overview.dto.StudentDto;
import com.example.Spring.Data.Overview.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto convertStudentToDto(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student must not be null");
        }

        return StudentDto.builder()
                .name(student.getName())
                .enrollmentId(student.getEnrollmentId())
                .age(student.getAge())
                .registrationDate(student.getRegistrationDate())
                .build();
    }

    public Student convertDtoToStudent(StudentDto studentDto) {
        if (studentDto == null) {
            throw new IllegalArgumentException("StudentDto must not be null");
        }

        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEnrollmentId(studentDto.getEnrollmentId());
        student.setAge(studentDto.getAge());
        student.setRegistrationDate(studentDto.getRegistrationDate());

        return student;
    }
}

