package com.example.many.to.many.dto;

import com.example.many.to.many.entity.Actor;
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
public class MovieDto {

    private Long id;

    private String name;

    private Set<ActorDto> actors = new HashSet<>();
}
