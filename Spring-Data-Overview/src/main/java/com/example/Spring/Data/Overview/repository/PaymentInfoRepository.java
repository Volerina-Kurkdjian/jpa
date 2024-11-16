package com.example.Spring.Data.Overview.repository;

import com.example.Spring.Data.Overview.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}
