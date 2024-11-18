package com.example.Spring.Data.Overview.dto.student;


import com.example.Spring.Data.Overview.model.Guide;
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

    private String name;
    private String enrollmentId;
    private Integer age;
    private List<String> subjects;
    private Date registrationDate;
    private Double amount;
    private Guide guide;
}
