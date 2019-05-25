package com.paf.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "ACCOUNT_ID")
	  private Long id;
	  
	  @Column(name = "CUSTOMER_FNAME")
	  private String fname;
	  
	  @Column(name = "CUSTOMER_LNAME")
	  private String lname;
	  
	  @Column(name = "ACCOUNT_BALANCE")
	  private double accountBalance;
	  
	  @Column(name = "CARD_NO")
	  private String cardNo;
	  
	  @Column(name = "CVC")
	  private int cvc;
	  
	  @Column(name = "CARD_EXPIRED_AT")
	  private Timestamp cardExpiredAt;
	  
	  @Column(name = "ACCOUNT_STATUS")
	  private String accountStatus;
	  
	  
	  
	  public Account(Long id, String fname, String lname, double accountBalance, String cardNo, int cvc,
			Timestamp cardExpiredAt, String accountStatus) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.accountBalance = accountBalance;
		this.cardNo = cardNo;
		this.cvc = cvc;
		this.cardExpiredAt = cardExpiredAt;
		this.accountStatus = accountStatus;
	}

	public Account() {
		  
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
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

	public Timestamp getCardExpiredAt() {
		return cardExpiredAt;
	}

	public void setCardExpiredAt(Timestamp cardExpiredAt) {
		this.cardExpiredAt = cardExpiredAt;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
}
