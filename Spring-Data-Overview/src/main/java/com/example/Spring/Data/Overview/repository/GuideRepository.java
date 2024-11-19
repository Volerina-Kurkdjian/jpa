package com.example.Spring.Data.Overview.repository;

import com.example.Spring.Data.Overview.model.Guide;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuideRepository extends JpaRepository<Guide, Long> {

        @EntityGraph(value="Guide.students", type= EntityGraph.EntityGraphType.LOAD)
        Optional<Guide> findById(Long id);
}
