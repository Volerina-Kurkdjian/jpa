package com.example.Spring.Data.Overview.controller;


import com.example.Spring.Data.Overview.dto.payment.PaymentAcknowledgement;
import com.example.Spring.Data.Overview.dto.payment.PaymentRequest;
import com.example.Spring.Data.Overview.service.payment.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/bookFlightTicket")
    public PaymentAcknowledgement bookFlightTicket(@RequestBody PaymentRequest request){
        return paymentService.payScholarTaxes(request);
    }

}
