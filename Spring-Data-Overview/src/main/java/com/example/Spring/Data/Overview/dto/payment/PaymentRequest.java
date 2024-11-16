package com.example.Spring.Data.Overview.dto.payment;

import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.model.PaymentInfo;
import com.example.Spring.Data.Overview.model.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class PaymentRequest {

    private PaymentInfo paymentInfo;
    private StudentDto studentDto;
}
