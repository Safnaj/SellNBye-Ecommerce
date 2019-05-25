package com.paf.model;

import java.sql.Timestamp;

public class PaymentRequest {
	
	private String publicKey;
	
	private String privateKey;
	
	private int orderId;
	
	private double amount;
	
	private String cardNo;
	
	private int cvc;
	
	private String cardExpiredAt;

	public PaymentRequest(String publicKey, String privateKey, int orderId ,double amount, String cardNo, int cvc,
			String cardExpiredAt) {
		super();
		this.publicKey = publicKey;
		this.privateKey = privateKey;
		this.orderId = orderId;
		this.amount = amount;
		this.cardNo = cardNo;
		this.cvc = cvc;
		this.cardExpiredAt = cardExpiredAt;
	}
	
	public PaymentRequest() {
		
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public String getCardExpiredAt() {
		return cardExpiredAt;
	}

	public void setCardExpiredAt(String cardExpiredAt) {
		this.cardExpiredAt = cardExpiredAt;
	}
	
	
}
