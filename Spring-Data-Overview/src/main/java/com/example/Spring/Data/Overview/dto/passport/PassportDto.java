package com.example.Spring.Data.Overview.dto.passport;

import com.example.Spring.Data.Overview.dto.student.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassportDto {

     private String countryCode;
     private StudentDto studentDto;
}
