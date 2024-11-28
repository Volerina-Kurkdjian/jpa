package com.example.inheritance.repository;

import com.example.inheritance.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {


}
