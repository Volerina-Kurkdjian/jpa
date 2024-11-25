package com.example.Spring.Data.Overview.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String country_code;
    @OneToOne(mappedBy = "passport",cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    private Student student;

    // Method to add a student
    public void addStudent(Student student) {
        this.student = student;
        student.setPassport(this);
    // Ensure the bi-directional relationship is maintained
    }


    // Method to remove a student
    public void removeStudent() {
        if (this.student != null) {
            this.student.setPassport(null);
            // Break the bi-directional relationship
            this.student = null; }
        }
}
