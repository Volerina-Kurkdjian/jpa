package com.example.Spring.Data.Overview.service.payment;

import com.example.Spring.Data.Overview.dto.payment.PaymentAcknowledgement;
import com.example.Spring.Data.Overview.dto.payment.PaymentRequest;

public interface PaymentService {

        PaymentAcknowledgement payScholarTaxes(PaymentRequest paymentRequest);
}
