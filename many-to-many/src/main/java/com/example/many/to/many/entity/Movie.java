package com.example.many.to.many.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    //the parent of the relationship, responsible for the relationship

    @ManyToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinTable(
            name="movie_actor",
            joinColumns={@JoinColumn(name="movie_id")},
            inverseJoinColumns={@JoinColumn(name="actor_id")}
    )
    private Set<Actor> actors = new HashSet<Actor>();

}
