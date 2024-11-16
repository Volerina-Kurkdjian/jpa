package com.example.Spring.Data.Overview.service;

import com.example.Spring.Data.Overview.dto.StudentDto;
import com.example.Spring.Data.Overview.dto.StudentResponse;
import com.example.Spring.Data.Overview.model.Student;

import java.util.List;

public interface StudentService {

    StudentDto saveStudent(StudentDto student);

    StudentResponse getAllStudents(int pageNo,int pageSize);

    StudentResponse getAllStudentsSortedByEnrollmentId(int pageNo, int pageSize);

    StudentResponse getAllStudentsSortedByEnrollmentIdAscendingAndNameDescending(int pageNo, int pageSize);

    StudentResponse findByEnrollmentIdOrderByDateDescNameAsc(int pageNo, int pageSize,String enrollmentId);
}
