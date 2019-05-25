package com.paf.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "TRANSACTION_ID")
	  private Long id;
	  
	  @Column(name = "ACCOUNT_ID")
	  private Long accountId;
	  
	  @Column(name = "AMOUNT")
	  private double amount;
	  
	  @Column(name = "TRANSACTION_TYPE")
	  private String transactionType;
	  
	  @Column(name = "TRANSACTION_STATUS")
	  private String transactionStatus;
	  
	  @Column(name = "CREATE_AT")
	  private Timestamp createAt;
	  
	  public Transaction(Long id, Long accountId, double amount, String transactionType, String transactionStatus,
			Timestamp createAt) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.createAt = createAt;
	}

	public Transaction() {
		  
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
	
}
