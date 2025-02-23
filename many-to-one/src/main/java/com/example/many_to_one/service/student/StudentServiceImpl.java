package com.example.many_to_one.service.student;

import com.example.many_to_one.dto.StudentDto;
import com.example.many_to_one.entity.Guide;
import com.example.many_to_one.entity.Student;
import com.example.many_to_one.mapper.StudentMapper;
import com.example.many_to_one.repository.GuideRepository;
import com.example.many_to_one.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{



    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GuideRepository guideRepository;

    @Override
    public StudentDto saveStudent(StudentDto student) {
        Student student1=studentMapper.toEntity(student);
        studentRepository.save(student1);
        return studentMapper.toStudentDto(student1);
    }

    @Transactional
    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(id) .orElseThrow(() -> new RuntimeException("Student not found"));
        // Map the fields from DTO to the existing entity
        existingStudent.setName(studentDto.getName());
        existingStudent.setEnrollmentId(studentDto.getEnrollmentId());
        existingStudent.setAge(studentDto.getAge());
        existingStudent.setSubjects(studentDto.getSubjects());
        existingStudent.setRegistrationDate(studentDto.getRegistrationDate());
        existingStudent.setAmount(studentDto.getAmount());
        // Optionally update the guide if provided in the DTO

        if (studentDto.getGuide() != null) {
            Guide guide = guideRepository.findById(studentDto.getGuide().getGuideId()).get();
            guide.setGuideId(studentDto.getGuide().getGuideId());
            guide.setStaffId(studentDto.getGuide().getStaffId());
            guide.setName(studentDto.getGuide().getName());
            guide.setSalary(studentDto.getGuide().getSalary());
            existingStudent.setGuide(guide);
            guideRepository.save(guide);
        }
        studentRepository.save(existingStudent);

        return studentMapper.toStudentDto(existingStudent);
    }

    @Transactional
    @Override
    public List<StudentDto.StudentDtoNameAndAmount> getStudents(Integer age) {
        List<Object[]> results =  studentRepository.findStudents(age);
        return results.stream()
                .map(result -> new StudentDto.StudentDtoNameAndAmount((String) result[0], (Double) result[1]))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<StudentDto.StudentDtoNameAndAmount> getStudentsByAge(Integer age) {
        List<Object[]> results = studentRepository.findNameAndAmountByAge(age);
        return results.stream()
                .map(result -> new StudentDto.StudentDtoNameAndAmount((String) result[0], (Double) result[1]))
                .collect(Collectors.toList());

    }

//    @Transactional
//    public Integer countStudentByAge(){
//
//    }
}
