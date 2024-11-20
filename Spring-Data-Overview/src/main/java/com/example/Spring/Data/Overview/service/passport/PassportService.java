package com.example.Spring.Data.Overview.service.passport;

import com.example.Spring.Data.Overview.dto.passport.PassportDto;
import com.example.Spring.Data.Overview.dto.student.StudentDto;

public interface PassportService {

     PassportDto createPassport(PassportDto passportDto);
     PassportDto updatePassport(Long id, PassportDto passportDto);
     void deletePassport(Long id);

    PassportDto addStudentToPassport(Long passportId, StudentDto studentDto);

    PassportDto removeStudentFromPassport(Long passportId);
}
