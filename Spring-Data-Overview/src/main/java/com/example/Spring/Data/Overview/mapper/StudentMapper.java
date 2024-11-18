package com.example.Spring.Data.Overview.mapper;

import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.model.Student;
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
                .amount(student.getAmount())
                .guide(student.getGuide())
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
        student.setAmount(studentDto.getAmount());
        student.setGuide(studentDto.getGuide());

        return student;
    }
}

