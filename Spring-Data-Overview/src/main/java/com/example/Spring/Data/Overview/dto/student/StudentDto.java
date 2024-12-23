package com.example.Spring.Data.Overview.dto.student;


import com.example.Spring.Data.Overview.dto.guide.GuideDto;
import com.example.Spring.Data.Overview.dto.passport.PassportDto;
import com.example.Spring.Data.Overview.model.Guide;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {

   // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private String enrollmentId;
    private Integer age;
    private List<String> subjects;
    private Date registrationDate;
    private Double amount;
    private GuideDto guide;
    private PassportDto passportDto;
}
