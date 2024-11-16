package com.example.Spring.Data.Overview.service.payment;

import com.example.Spring.Data.Overview.dto.payment.PaymentAcknowledgement;
import com.example.Spring.Data.Overview.dto.payment.PaymentRequest;
import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.mapper.StudentMapper;
import com.example.Spring.Data.Overview.model.PaymentInfo;
import com.example.Spring.Data.Overview.model.Student;
import com.example.Spring.Data.Overview.repository.PaymentInfoRepository;
import com.example.Spring.Data.Overview.repository.StudentRepository;
import com.example.Spring.Data.Overview.utils.PaymentUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    @Transactional
    @Override
    public PaymentAcknowledgement payScholarTaxes(PaymentRequest paymentRequest) {

        //getting the student and saving it
        StudentDto studentDto=paymentRequest.getStudentDto();
        Student student=studentMapper.convertDtoToStudent(studentDto);
        studentRepository.save(student);

        //getting Payment Info
        PaymentInfo paymentInfo=paymentRequest.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), student.getAmount());

        paymentInfo.setAmount(student.getAmount());
        paymentInfo.setStudentId(student.getId());
        paymentInfoRepository.save(paymentInfo);


        return new PaymentAcknowledgement("Success", student.getAmount(), UUID.randomUUID().toString().split("-")[0],studentDto);
    }
}
