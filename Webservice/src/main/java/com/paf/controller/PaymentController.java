package com.paf.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paf.model.Payment;
import com.paf.model.PaymentRequest;
import com.paf.model.SuccessResponse;
import com.paf.model.UpdatePaymentTransaction;
import com.google.gson.Gson;
import com.paf.dao.PaymentDAO;
@RestController
public class PaymentController {

  private final PaymentDAO paymentDAO;
	  
  @Autowired
  PaymentController(PaymentDAO paymentDAO) {
	    this.paymentDAO = paymentDAO;
  }

	/* to save an payment*/
	@PostMapping("/payments")
	public Payment createPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
		
//		int orderId = paymentRequest.getOrderId();
//		double orderTotalAmount = paymentRequest.getAmount();
//		String cardNO = paymentRequest.getCardNo();
//		int cvc = paymentRequest.getCvc();
//		String cardExpiredAt = paymentRequest.getCardExpiredAt();
		
		final String uri = "http://localhost:8080/accounts/makePayment";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response = restTemplate.postForEntity( uri, paymentRequest, String.class );
		Gson gson = new Gson();
		SuccessResponse responseData = gson.fromJson(response.getBody().toString(), SuccessResponse.class);
		Payment payment = new Payment();
		
		if(responseData.getStatus() == true) {
			payment.setOrderId(paymentRequest.getOrderId());
			payment.setPaymentMethod("visa");
			long transactionId = Long.parseLong(responseData.getResponseText());
			payment.setTransactionId(transactionId);
			payment.setPaymentStatus("complete");
			Date today = new Date();
			Timestamp t2 = getTimestamp(today);
			payment.setPaymentCreateAt(t2);
			return paymentDAO.save(payment);
		}
		
		return payment;
		
	}
	
	public static Timestamp getTimestamp(Date date) { return date == null ? null : new java.sql.Timestamp(date.getTime()); }

	
	
	
	/*get all payments*/
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){

		return paymentDAO.findAll();
	}
	
	

	/*get payment by paymentid*/
	@GetMapping("/payments/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value="id") Long paymentid){
		
		Payment payment= paymentDAO.findOne(paymentid);
		
		if(payment==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(payment);
		
	}
	
	/*update an payment by paymentid*/
	@PutMapping("/payments/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable(value="id") Long paymentid,@Valid @RequestBody Payment paymentDetails){
		
		Payment payment=paymentDAO.findOne(paymentid);
		if(payment==null) {
			return ResponseEntity.notFound().build();
		}
		
		payment.setTransactionId(paymentDetails.getTransactionId());
		payment.setPaymentMethod(paymentDetails.getPaymentMethod());
		payment.setPaymentStatus(paymentDetails.getPaymentStatus());
		payment.setPaymentCreateAt(paymentDetails.getPaymentCreateAt());
		Payment updatePayment=paymentDAO.save(payment);
		return ResponseEntity.ok().body(updatePayment);
		
		
		
	}
	
	/*Delete an payment*/
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Payment> deleteEmployee(@PathVariable(value="id") Long paymentid){
		
		Payment payment = paymentDAO.findOne(paymentid);
		if(payment==null) {
			return ResponseEntity.notFound().build();
		}
		boolean status = this.cancelPayment(paymentid);
		if(status)
			paymentDAO.delete(payment);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	public boolean cancelPayment(Long paymentId) {
		
		Payment payment= paymentDAO.findOne(paymentId);
		UpdatePaymentTransaction updatePaymentTransaction = new UpdatePaymentTransaction();
		
		updatePaymentTransaction.setTransactionId(payment.getTransactionId());
		updatePaymentTransaction.setTransactionType("debit");
		
		final String uri = "http://localhost:8080/accounts/updatePayment";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response = restTemplate.postForEntity( uri, updatePaymentTransaction, String.class );
		Gson gson = new Gson();
		SuccessResponse responseData = gson.fromJson(response.getBody().toString(), SuccessResponse.class);
		
		if(responseData.getStatus()) 
			return true;
		
		return false;
	}

}
