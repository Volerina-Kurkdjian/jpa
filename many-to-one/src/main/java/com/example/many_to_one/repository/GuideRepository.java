package com.example.many_to_one.repository;


import com.example.many_to_one.dto.GuideDto;
import com.example.many_to_one.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface GuideRepository extends JpaRepository<Guide, Long> {

         Optional<Guide> findById(Long id);

         @Query("SELECT g FROM Guide g WHERE g.staffId = :staffId")
         Guide findByStaffId(@Param("staffId") String staffId);

         List<GuideDto.GuideDtoProjection> findFirst3BySalaryGreaterThan(Integer salary);
}
