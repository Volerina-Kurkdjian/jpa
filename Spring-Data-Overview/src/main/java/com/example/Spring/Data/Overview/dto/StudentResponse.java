package com.example.Spring.Data.Overview.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class StudentResponse {

    private List<StudentDto> studentList;
    private int nbPages;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

}
