package com.example.Spring.Data.Overview.mapper;


import com.example.Spring.Data.Overview.dto.guide.GuideDto;
import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.model.Guide;
import com.example.Spring.Data.Overview.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GuideMapper {

    private final StudentMapper studentMapper;

     public GuideDto convertToDto(Guide guide) {

         if (guide == null) {
             throw new IllegalArgumentException("Guide must not be null");
         }

//         Set<StudentDto> studentDtoSet = new HashSet<>();
//         for (Student student : guide.getStudents()) {
//             StudentDto studentDto = studentMapper.convertStudentToDto(student);
//             studentDtoSet.add(studentDto);
//         }

         return GuideDto.builder() .staffId(guide.getStaffId())
                 .name(guide.getName())
                 .salary(guide.getSalary())
                 //.studentList(studentDtoSet)
                 .build();
    }

    public Guide convertToEntity(GuideDto guideDto) {
        if (guideDto == null) {
            throw new IllegalArgumentException("GuideDto must not be null");
        }
        Guide guide = new Guide();
        guide.setStaffId(guideDto.getStaffId());
        guide.setName(guideDto.getName());
        guide.setSalary(guideDto.getSalary());

        Set<Student> studentSet = new HashSet<>();
        for (StudentDto studentDto : guideDto.getStudentList()) {
            Student student = convertDtoToStudent(studentDto);
            studentSet.add(student);
        }


        guide.setStudents(studentSet);
        return guide;
    }

    public Student convertDtoToStudent(StudentDto studentDto) {
//        if (studentDto == null) {
//            throw new IllegalArgumentException("StudentDto must not be null");
//        }

        // Guide guide=convertToEntity(studentDto.getGuide());
        // Passport passport=convertToEntity(studentDto.getPassportDto());

        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEnrollmentId(studentDto.getEnrollmentId());
        student.setAge(studentDto.getAge());
        student.setRegistrationDate(studentDto.getRegistrationDate());
        student.setAmount(studentDto.getAmount());
        //student.setPassport(convertToEntity(studentDto.getPassportDto()));
       // student.setGuide(convertToEntity(studentDto.getGuide()));

        return student;
    }

    ///////////////////////////////////////////////////////////////////////////
        public GuideDto toGuideDTO(Guide guide) {
             if (guide == null) {
                 return null;
             }
             GuideDto guideDTO = new GuideDto();
             guideDTO.setGuideId(guide.getGuideId());
             guideDTO.setStaffId(guide.getStaffId());
             guideDTO.setName(guide.getName());
             guideDTO.setSalary(guide.getSalary());
             guideDTO.setStudentList(guide.getStudents().stream() .map(this::toStudentDTO) .collect(Collectors.toSet()));
             return guideDTO;
        }

     // Convert DTO to Guide entity
        public Guide toGuideEntity(GuideDto guideDTO) {
             if (guideDTO == null) {
                 return null;
             }
             Guide guide = new Guide();
             guide.setGuideId(guideDTO.getGuideId());
             guide.setStaffId(guideDTO.getStaffId());
             guide.setName(guideDTO.getName());
             guide.setSalary(guideDTO.getSalary());
             guide.setStudents(guideDTO.getStudentList().stream() .map(this::toStudentEntity) .collect(Collectors.toSet()));
             return guide;
        }

     // Convert Student entity to DTO
        public StudentDto toStudentDTO(Student student) {
             if (student == null) {
                 return null;
             }
            StudentDto studentDTO = new StudentDto();
             studentDTO.setId(student.getId());
             studentDTO.setName(student.getName());
             studentDTO.setEnrollmentId(student.getEnrollmentId());
             studentDTO.setAge(student.getAge());
             studentDTO.setSubjects(student.getSubjects());
             studentDTO.setRegistrationDate(student.getRegistrationDate());
             studentDTO.setAmount(student.getAmount());
             return studentDTO;
        }
     // Convert DTO to Student entity
        public Student toStudentEntity(StudentDto studentDTO) {
             if (studentDTO == null) {
                 return null;
             }
             Student student = new Student();
             student.setId(studentDTO.getId());
             student.setName(studentDTO.getName());
             student.setEnrollmentId(studentDTO.getEnrollmentId());
             student.setAge(studentDTO.getAge());
             student.setSubjects(studentDTO.getSubjects());
             student.setRegistrationDate(studentDTO.getRegistrationDate());
             student.setAmount(studentDTO.getAmount());
             return student;
        }

}
