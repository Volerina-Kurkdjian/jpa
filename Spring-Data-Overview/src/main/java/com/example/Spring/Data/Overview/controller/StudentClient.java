package com.example.Spring.Data.Overview.controller;

import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.dto.student.StudentResponse;
import com.example.Spring.Data.Overview.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentClient  {


    private final StudentService studentService;

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,@RequestBody StudentDto studentDto) {
      //  studentDto.setId(id); // Ensure the ID is set in the DTO
        StudentDto updatedStudent = studentService.updateStudent(id,studentDto);
        return ResponseEntity.ok(updatedStudent);
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student){

        return ResponseEntity.status(HttpStatus.OK).body( studentService.saveStudent(student));
    }



    @GetMapping("/getAllStudents")
    public ResponseEntity<StudentResponse> getStudents(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){

        return new ResponseEntity<>(studentService.getAllStudents(pageNo,pageSize),HttpStatus.OK);
    }


    @GetMapping("/getAllStudentsSortedByEnrollmentId")
    public ResponseEntity<StudentResponse> getStudentsSortedByName(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){

        return new ResponseEntity<>(studentService.getAllStudentsSortedByEnrollmentId(pageNo,pageSize),HttpStatus.OK);
    }

    @GetMapping("/getAllStudentsByEnrollmentIdOrderByDateDescNameAsc")
    public ResponseEntity<StudentResponse> getStudentsSortedByByEnrollmentIdOrderByDateDescNameAsc(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "enrollmentId", required = false) String enrollmentId){

        return new ResponseEntity<>(studentService.findByEnrollmentIdOrderByDateDescNameAsc(pageNo,pageSize,enrollmentId),HttpStatus.OK);
    }


}
