package com.example.inheritance.repository;

import com.example.inheritance.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {


}
