package com.example.Spring.Data.Overview.mapper;

import com.example.Spring.Data.Overview.dto.guide.GuideDto;
import com.example.Spring.Data.Overview.dto.passport.PassportDto;
import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.model.Guide;
import com.example.Spring.Data.Overview.model.Passport;
import com.example.Spring.Data.Overview.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentMapper {

   // private final GuideMapper guideMapper;
    //private final PassportMapper passportMapper;

    public StudentDto convertStudentToDto(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student must not be null");
        }

        //Guide guide=student.getGuide();
       // Passport passport=student.getPassport();

       // GuideDto guideDto=guideMapper.convertToDto(guide);
        //PassportDto passportDto=convertToDto(student.getPassport());

        if(convertToDto(student.getGuide())!=null){
            Guide guide=student.getGuide();
            return StudentDto.builder()
                    .name(student.getName())
                    .enrollmentId(student.getEnrollmentId())
                    .age(student.getAge())
                    .registrationDate(student.getRegistrationDate())
                    .amount(student.getAmount())
                    .passportDto(convertToDto(student.getPassport()))
                    .guide(convertToDto(student.getGuide()))
                    .build();
        }

        if(convertToDto(student.getPassport())!=null){
            PassportDto passportDto=convertToDto(student.getPassport());
            return StudentDto.builder()
                    .name(student.getName())
                    .enrollmentId(student.getEnrollmentId())
                    .age(student.getAge())
                    .registrationDate(student.getRegistrationDate())
                    .amount(student.getAmount())
                    .passportDto(convertToDto(student.getPassport()))
                    .guide(convertToDto(student.getGuide()))
                    .build();
        }

        return StudentDto.builder()
                .name(student.getName())
                .enrollmentId(student.getEnrollmentId())
                .age(student.getAge())
                .registrationDate(student.getRegistrationDate())
                .amount(student.getAmount())
               // .passportDto(convertToDto(student.getPassport()))
//                .guide(convertToDto(student.getGuide()))
                .build();
    }

    public Student convertDtoToStudent(StudentDto studentDto) {
//        if (studentDto == null) {
//            throw new IllegalArgumentException("StudentDto must not be null");
//        }

       // Guide guide=convertToEntity(studentDto.getGuide());
       // Passport passport=convertToEntity(studentDto.getPassportDto());

        if(convertToEntity(studentDto.getGuide())!=null){
            Student student = new Student();
            student.setName(studentDto.getName());
            student.setEnrollmentId(studentDto.getEnrollmentId());
            student.setAge(studentDto.getAge());
            student.setRegistrationDate(studentDto.getRegistrationDate());
            student.setAmount(studentDto.getAmount());
            student.setPassport(convertToEntity(studentDto.getPassportDto()));
            student.setGuide(convertToEntity(studentDto.getGuide()));
            return student;
        }

        if(convertToEntity(studentDto.getPassportDto())!=null){
            Student student = new Student();
            student.setName(studentDto.getName());
            student.setEnrollmentId(studentDto.getEnrollmentId());
            student.setAge(studentDto.getAge());
            student.setRegistrationDate(studentDto.getRegistrationDate());
            student.setAmount(studentDto.getAmount());
            student.setGuide(convertToEntity(studentDto.getGuide()));
            student.setPassport(convertToEntity(studentDto.getPassportDto()));

            return student;
        }

        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEnrollmentId(studentDto.getEnrollmentId());
        student.setAge(studentDto.getAge());
        student.setRegistrationDate(studentDto.getRegistrationDate());
        student.setAmount(studentDto.getAmount());
//        student.setPassport(convertToEntity(studentDto.getPassportDto()));
//        student.setGuide(convertToEntity(studentDto.getGuide()));

        return student;
    }


    public Guide convertToEntity(GuideDto guideDto) {
        if (guideDto == null) {
            throw new IllegalArgumentException("GuideDto must not be null");
        }
        Guide guide = new Guide();
        guide.setStaffId(guideDto.getStaffId());
        guide.setName(guideDto.getName());
        guide.setSalary(guideDto.getSalary());

        return guide;
    }

    public GuideDto convertToDto(Guide guide) {

        if (guide == null) {
            return null;
        }

        return GuideDto.builder() .staffId(guide.getStaffId())
                .name(guide.getName())
                .salary(guide.getSalary())
                .build();
    }

    public PassportDto convertToDto(Passport passport) {
        if (passport == null) {
            return null;
        }

        PassportDto passportDto = new PassportDto();

        // passportDto.setId(passport.getId());
        passportDto.setCountryCode(passport.getCountry_code());
        // Convert and set the associated student
        //  passportDto.setStudentDto(studentMapper.convertStudentToDto(passport.getStudent()));
        return passportDto;
    }

    public Passport convertToEntity(PassportDto passportDto) {

        if (passportDto == null) {
            return null;
        }
        Passport passport = new Passport();
        //passport.setId(passportDto.getId());
        passport.setCountry_code(passportDto.getCountryCode());
        // Convert and set the associated student
        //  passport.setStudent(studentMapper.convertDtoToStudent(passportDto.getStudentDto()));

        return passport;
    }
}

