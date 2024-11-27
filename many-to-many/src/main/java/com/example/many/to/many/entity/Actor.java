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
public class Actor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    //the inverse end, because it has mappedBy
    @ManyToMany(mappedBy="actors", cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    private Set<Movie> movies = new HashSet<Movie>();

    public void addMovie(Movie movie) {
        this.movies.add(movie);
        movie.getActors().add(this);
    }
    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
        movie.getActors().remove(this);
    }

}
