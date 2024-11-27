package com.example.many.to.many.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActorDto {

    @JsonIgnore
    private Long id;

    private String name;

    private Set<MovieDto> movies = new HashSet<>();
}
