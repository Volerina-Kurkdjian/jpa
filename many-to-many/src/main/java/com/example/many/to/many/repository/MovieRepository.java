package com.example.many.to.many.repository;

import com.example.many.to.many.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
