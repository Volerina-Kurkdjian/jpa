package com.example.Spring.Data.Overview.dto.payment;

import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAcknowledgement {

    private String status;
    private double totalFare;
    private String pnrNo;
    private StudentDto studentInfo;

}
