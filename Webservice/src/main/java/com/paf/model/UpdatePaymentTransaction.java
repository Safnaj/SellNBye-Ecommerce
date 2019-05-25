package com.paf.model;

public class UpdatePaymentTransaction {

	  
	  private Long transactionId;
	  
	  private double amount;
	  
	  private String transactionType; // credit,debit
	  
	  
	  public UpdatePaymentTransaction() {
		  
	  }


	public UpdatePaymentTransaction(Long transactionId, double amount, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionType = transactionType;
	}


	public Long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	  
	  
	  
}
