package com.example.Spring.Data.Overview.repository;

import com.example.Spring.Data.Overview.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Long> {


}
