package com.example.Spring.Data.Overview.dto.guide;

import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideDto {

    private String staffId;
    private String name;
    private Integer salary;
    Set<StudentDto> studentList;
}
