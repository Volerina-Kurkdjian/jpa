package com.example.Spring.Data.Overview.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

//we can define them here on Entity, but will have to comment on Repository
@NamedQuery(name="Student.findByName",
        query="select s from Student s where s.name = :name")  // Use :name for parameter binding

@NamedNativeQuery(name="Student.findByNameEndingWith",
        query="select * from student where name like %?1") // Use ?1 for positional parameter binding (starts from 1)
@Entity
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(name="enrollment_id")
    private String enrollmentId;

    @Column
    private Integer age;

    @Column
    private List<String> subjects;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    private Double amount;

    //cascade = {CascadeType.PERSIST} when we use it, we don't need to save the Guide separately in the service when saving a Student
    //fetch = FetchType.LAZY  by default @ManyToOne is EAGER,
    // means that it will also load the child when fetching the parent behind it is a full outer join
    //CascadeType.MERGE ---> pentru a putea face update la un Guide din Student
    //CascadeType.PERSIST ---> pentru a salva un Guide din Student
    //This is the parent of the relationship, the many side is the owner of the relationship

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="guide_id")
    private Guide guide;
}
