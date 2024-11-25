package com.example.Spring.Data.Overview.mapper;

import com.example.Spring.Data.Overview.dto.passport.PassportDto;
import com.example.Spring.Data.Overview.model.Passport;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PassportMapper {

    private final StudentMapper studentMapper;


    public PassportDto convertToDto(Passport passport) {
        if (passport == null) {
            return null;
        }

        PassportDto passportDto = new PassportDto();

       // passportDto.setId(passport.getId());
        passportDto.setCountryCode(passport.getCountry_code());
        // Convert and set the associated student
        passportDto.setStudentDto(studentMapper.convertStudentToDto(passport.getStudent()));
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
        passport.setStudent(studentMapper.convertDtoToStudent(passportDto.getStudentDto()));

        return passport;
    }
}
