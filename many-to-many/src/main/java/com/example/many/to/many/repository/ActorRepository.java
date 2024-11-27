package com.example.many.to.many.repository;

import com.example.many.to.many.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {

}
