package com.example.Spring.Data.Overview.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guideId;
    @Column(name = "staff_id", nullable = false)
    private String staffId;
    private String name;
    private Integer salary;
    /**mappedBy makes the relationship bi-directional
    //marks the child in the relationship*/
    @OneToMany(mappedBy = "guide",cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    Set<Student> studentList;

    public void addStudent(Student student) {
        studentList.add(student); student.setGuide(this);
        // Ensure the bi-directional relationship is maintained
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
        student.setGuide(null);
        // Break the bi-directional relationship
    }
}
