package com.example.many_to_one.entity;

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
    @OneToMany(mappedBy = "guide",cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
    Set<Student> students=new HashSet<>();

    public void addStudent(Student student) {
        if (students == null) {
            students = new HashSet<>();
        }
        students.add(student);
        student.setGuide(this);
        // Ensure the bi-directional relationship is maintained
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setGuide(null);
        // Break the bi-directional relationship
    }


}
