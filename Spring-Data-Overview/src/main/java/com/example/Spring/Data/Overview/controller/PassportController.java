package com.example.Spring.Data.Overview.controller;

import com.example.Spring.Data.Overview.dto.passport.PassportDto;
import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.service.passport.PassportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passport")
@AllArgsConstructor
public class PassportController {


    private final PassportService passportService;

    @PostMapping("/{passportId}/student")
    public ResponseEntity<PassportDto> addStudentToPassport(@PathVariable Long passportId, @RequestBody StudentDto studentDto) {
        PassportDto updatedPassport = passportService.addStudentToPassport(passportId, studentDto);
        return ResponseEntity.ok(updatedPassport);
    }

    @DeleteMapping("/{passportId}/student") public ResponseEntity<PassportDto> removeStudentFromPassport(@PathVariable Long passportId) {
        PassportDto updatedPassport = passportService.removeStudentFromPassport(passportId);
        return ResponseEntity.ok(updatedPassport);
    }

    @PostMapping
    public ResponseEntity<PassportDto> createPassport(@RequestBody PassportDto passportDto) {
        PassportDto createdPassport = passportService.createPassport(passportDto);
         return ResponseEntity.status(201).body(createdPassport);
    }
}
