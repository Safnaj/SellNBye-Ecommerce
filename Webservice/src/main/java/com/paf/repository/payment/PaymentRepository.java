package com.paf.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paf.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {


}
