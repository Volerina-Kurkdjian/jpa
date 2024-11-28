package com.example.inheritance.repository;

import com.example.inheritance.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("select a from Animal a")
    List<Animal> findAll();
}
