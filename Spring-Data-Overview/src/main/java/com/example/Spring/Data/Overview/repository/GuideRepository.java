package com.example.Spring.Data.Overview.repository;

import com.example.Spring.Data.Overview.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GuideRepository extends JpaRepository<Guide, Long> {


        Optional<Guide> findById(Long id);

         @Query("SELECT g FROM Guide g WHERE g.staffId = :staffId")
         Guide findByStaffId(@Param("staffId") String staffId);
}
