package com.example.Spring.Data.Overview.service;

import com.example.Spring.Data.Overview.dto.StudentDto;
import com.example.Spring.Data.Overview.dto.StudentResponse;
import com.example.Spring.Data.Overview.mapper.StudentMapper;
import com.example.Spring.Data.Overview.model.Student;
import com.example.Spring.Data.Overview.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentDto saveStudent(StudentDto student) {

        // Convert to Student entity
        Student savedStudent = studentMapper.convertDtoToStudent(student);

        // Save the Student entity
        savedStudent = studentRepository.save(savedStudent);

        // Convert the saved entity back to StudentDto (if necessary)
        StudentDto studentDto = studentMapper.convertStudentToDto(savedStudent);

        // Return the StudentDto
        return studentDto;
    }

    @Override
    public StudentResponse getAllStudents(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo,pageSize);
        Page<Student> students=studentRepository.findAll(pageable);

        List<Student> studentList=students.getContent();
        List<StudentDto> studentDtoList=studentList.stream().map(s->studentMapper.convertStudentToDto(s)).collect(Collectors.toList());

        StudentResponse studentResponse=new StudentResponse();
        studentResponse.setStudentList(studentDtoList);
        studentResponse.setNbPages(students.getNumber());
        studentResponse.setPageSize(students.getSize());
        studentResponse.setTotalElements(students.getTotalElements());
        studentResponse.setTotalPages(students.getTotalPages());
        studentResponse.setLast(students.isLast());

        return studentResponse;
    }

    @Override
    public StudentResponse getAllStudentsSortedByEnrollmentId(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by("enrollmentId"));
        Page<Student> students = studentRepository.findAll(pageable);
        List<StudentDto> studentDtoList = students.getContent().stream().map(studentMapper::convertStudentToDto).collect(Collectors.toList());

        return StudentResponse.builder()
                .studentList(studentDtoList)
                .nbPages(students.getNumber())
                .pageSize(students.getSize())
                .totalElements(students.getTotalElements())
                .totalPages(students.getTotalPages())
                .last(students.isLast()) .build();
    }

    @Override
    public StudentResponse getAllStudentsSortedByEnrollmentIdAscendingAndNameDescending(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by("enrollmentId").ascending().and(Sort.by("name").descending()));
        Page<Student> students = studentRepository.findAll(pageable);
        List<StudentDto> studentDtoList = students.getContent().stream().map(studentMapper::convertStudentToDto).collect(Collectors.toList());

        return StudentResponse.builder()
                .studentList(studentDtoList)
                .nbPages(students.getNumber())
                .pageSize(students.getSize())
                .totalElements(students.getTotalElements())
                .totalPages(students.getTotalPages())
                .last(students.isLast()) .build();
    }

    @Override
    public StudentResponse findByEnrollmentIdOrderByDateDescNameAsc(int pageNo, int pageSize,String enrollmentId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by("registrationDate").ascending().and(Sort.by("name").descending()));
        Page<Student> students = studentRepository.findByEnrollmentId(enrollmentId,pageable);
        List<StudentDto> studentDtoList = students.getContent().stream().map(studentMapper::convertStudentToDto).collect(Collectors.toList());

        return StudentResponse.builder()
                .studentList(studentDtoList)
                .nbPages(students.getNumber())
                .pageSize(students.getSize())
                .totalElements(students.getTotalElements())
                .totalPages(students.getTotalPages())
                .last(students.isLast()) .build();
    }
}
