package com.example.Spring.Data.Overview.service;

import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.dto.student.StudentResponse;
import com.example.Spring.Data.Overview.mapper.GuideMapper;
import com.example.Spring.Data.Overview.mapper.PassportMapper;
import com.example.Spring.Data.Overview.mapper.StudentMapper;
import com.example.Spring.Data.Overview.model.Guide;
import com.example.Spring.Data.Overview.model.Passport;
import com.example.Spring.Data.Overview.model.Student;
import com.example.Spring.Data.Overview.repository.GuideRepository;
import com.example.Spring.Data.Overview.repository.PassportRepository;
import com.example.Spring.Data.Overview.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    @Transactional
    @Override
    public StudentDto saveStudent(StudentDto student) {

        // Convert to Student entity
        Student savedStudent = studentMapper.convertDtoToStudent(student);

        // Save the Student entity
        savedStudent = studentRepository.save(savedStudent);

//          THIS RESULTS IN 500 ERROR
        //save guide
//        Guide guide=guideMapper.convertToEntity(student.getGuide());
//        guideRepository.save(guide);
//        //save passport
//        Passport passport=passportMapper.convertToEntity(student.getPassportDto());
//        passportRepository.save(passport);
//

        // Convert the saved entity back to StudentDto (if necessary)
        StudentDto studentDto = studentMapper.convertStudentToDto(savedStudent);// when saving a Student it will cascade saving a Guide and a Passport

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

    @Override
    public StudentDto updateStudent(Long id,StudentDto studentDto) {

        //up until now it will create new Guide and new Passport associated with the Student
        //need changes to update the already existing Guide and Passport
        Student student= studentRepository.findById(id).get();
        student.setGuide(studentMapper.convertDtoToStudent(studentDto).getGuide());
        student.setPassport(studentMapper.convertDtoToStudent(studentDto).getPassport());
        student.setAge(studentMapper.convertDtoToStudent(studentDto).getAge());
        student.setAmount(studentMapper.convertDtoToStudent(studentDto).getAmount());
        student.setName(studentMapper.convertDtoToStudent(studentDto).getName());
        student.setAge(studentMapper.convertDtoToStudent(studentDto).getAge());

        studentRepository.save(student);

        return studentMapper.convertStudentToDto(student);
    }
}
