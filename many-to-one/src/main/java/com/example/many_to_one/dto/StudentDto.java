package com.example.many_to_one.dto;

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


   public record StudentDtoNameAndAmount(String name,Double amount){

    }
}
