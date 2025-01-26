package com.example.inheritance.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DogDto {

    String name;
    String color;
    String breed;
    Integer age;
    Float weight;
    Integer height;
}
