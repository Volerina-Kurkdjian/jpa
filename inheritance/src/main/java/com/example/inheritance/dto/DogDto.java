package com.example.inheritance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DogDto {

    String name;
    String color;
    String breed;
    Integer age;
    Float weight;
    Integer height;
}
