package com.example.Spring.Data.Overview.repository;

import com.example.Spring.Data.Overview.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findFirst2ByEnrollmentIdStartingWithAndNameLike(String enrollmentId,String name);

    //we commented the queries on Repository because they are defined on Entity class
    // @Query("select s from Student s where s.name=:name")
    List<Student> findByName(String name);

    //@Query(value="select * from student where name like %?", nativeQuery = true)
    List<Student> findByNameEndingWith(String name);

    Page<Student> findAll(Pageable pageable);

   // Page<Student> findByEnrollmentIdOrderByDateDescNameAsc(String enrollmentId);

    Page<Student> findByEnrollmentId(String enrollmentId, Pageable sort);

}