package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.model.Payment;
import com.paf.repository.payment.PaymentRepository;

@Service
public class PaymentDAO {

	@Autowired
	PaymentRepository paymentRepository;
	
	/*to save an payment*/
	
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	
	/* search all payments*/
	
	public List<Payment> findAll(){
		return paymentRepository.findAll();
	}
	
	
	/*get an payment by id*/
	public Payment findOne(Long paymentid) {
		return paymentRepository.findOne(paymentid);
	}
	
	
	/*delete an payment*/
	
	public void delete(Payment payment) {
		paymentRepository.delete(payment);
	}
}
