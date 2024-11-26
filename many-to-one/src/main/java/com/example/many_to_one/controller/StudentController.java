package com.example.many_to_one.controller;


import com.example.many_to_one.dto.StudentDto;
import com.example.many_to_one.entity.Student;
import com.example.many_to_one.service.student.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        //  studentDto.setId(id); // Ensure the ID is set in the DTO
        StudentDto updatedStudent = studentService.updateStudent(id,studentDto);
        return ResponseEntity.ok(updatedStudent);
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student){
        return ResponseEntity.status(HttpStatus.OK).body( studentService.saveStudent(student));
    }

    @GetMapping("/getStudents/{age}")
    public ResponseEntity<List<StudentDto.StudentDtoNameAndAmount>> getStudentsByAge(@PathVariable Integer age){
        return ResponseEntity.status(HttpStatus.OK).body( studentService.getStudents(age));
    }

    @GetMapping("/getSecondProcedureStudents/{age}")
    public ResponseEntity<List<StudentDto.StudentDtoNameAndAmount>> getSecondProcedureStudentsByAge(@PathVariable Integer age){
        return ResponseEntity.status(HttpStatus.OK).body( studentService.getStudentsByAge(age));
    }
}
