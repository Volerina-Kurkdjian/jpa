package com.example.Spring.Data.Overview.repository;

import com.example.Spring.Data.Overview.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {


}
