package com.example.Spring.Data.Overview.service.passport;

import com.example.Spring.Data.Overview.dto.passport.PassportDto;
import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.mapper.PassportMapper;
import com.example.Spring.Data.Overview.mapper.StudentMapper;
import com.example.Spring.Data.Overview.model.Passport;
import com.example.Spring.Data.Overview.model.Student;
import com.example.Spring.Data.Overview.repository.PassportRepository;
import com.example.Spring.Data.Overview.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PassportServiceImpl implements PassportService{


    private final PassportRepository passportRepository;

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    private final PassportMapper passportMapper;


    @Override
    @Transactional
    public PassportDto createPassport(PassportDto passportDto) {
        Passport passport = passportMapper.convertToEntity(passportDto);
        // Ensure the student exists before setting it

        passport = passportRepository.save(passport);
        PassportDto passportDto1=passportMapper.convertToDto(passport);

        if (passportDto.getStudentDto() != null) {
            studentRepository.save(passport.getStudent());

            Student student = studentRepository.findById(passport.getStudent().getId()).get();
            passportDto1.setStudentDto( studentMapper.convertStudentToDto(student));
        }

        return passportDto1;
    }

    @Override
    public PassportDto updatePassport(Long id, PassportDto passportDto) {
        return null;
    }

    @Override
    public void deletePassport(Long id) {

    }

    @Override
    public PassportDto addStudentToPassport(Long passportId, StudentDto studentDto) {

        Passport passport = passportRepository.findById(passportId).get();
        Student student = studentMapper.convertDtoToStudent(studentDto); studentRepository.save(student);
        // Save student to generate ID
        passport.addStudent(student);
        passportRepository.save(passport);

        return passportMapper.convertToDto(passport);

    }

    @Override
    public PassportDto removeStudentFromPassport(Long passportId) {

        Passport passport = passportRepository.findById(passportId).get();
        passport.removeStudent();
        passportRepository.save(passport);

        return passportMapper.convertToDto(passport);
    }
}
