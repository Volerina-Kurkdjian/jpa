package com.example.many_to_one.dto;


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

    private Long guideId;
    private String staffId;
    private String name;
    private Integer salary;
    Set<StudentDto> students;

    public record GuideDtoProjection(String name,Integer salary){

    }


}
