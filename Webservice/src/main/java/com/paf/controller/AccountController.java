package com.paf.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paf.dao.AccountDAO;
import com.paf.dao.TransactionDAO;
import com.paf.model.Account;
import com.paf.model.PaymentRequest;
import com.paf.model.SuccessResponse;
import com.paf.model.Transaction;
import com.paf.model.UpdatePaymentTransaction;

@RestController
public class AccountController {


	  private final AccountDAO accountDAO;
	  private final TransactionDAO transactionDAO;

	  @Autowired
	  AccountController(AccountDAO accountDAO , TransactionDAO transactionDAO) {
	    this.accountDAO = accountDAO;
	    this.transactionDAO = transactionDAO;
	  }
	  
		/* to save an account*/
		@PostMapping("/accounts")
		public Account createAccount(@Valid @RequestBody Account account) {
			return accountDAO.save(account);
		}
		
		/*get all accounts*/
		@GetMapping("/accounts")
		public List<Account> getAllAccounts(){
			return accountDAO.findAll();
		}
		
		/*check accounts*/
		@PostMapping("/accounts/makePayment")
		public SuccessResponse checkAccountsDetails(@Valid @RequestBody PaymentRequest paymentRequest){
			
			String cardNo = paymentRequest.getCardNo();
			int cvc = paymentRequest.getCvc();
			String publicKey = paymentRequest.getPublicKey();
			String privateKey = paymentRequest.getPrivateKey();
			double amount = paymentRequest.getAmount();
			String cardExpiredAt = paymentRequest.getCardExpiredAt();
			
			
			SuccessResponse successResponse = new SuccessResponse();
			
			List<Account> accounts= accountDAO.findAll();
			for (final Account account : accounts) {
		          if(account.getCardNo().equalsIgnoreCase(cardNo) && account.getCvc() == cvc) {
		        	  Long accountId = account.getId();
		        	  
		        	  if(account.getAccountBalance() > amount) {
		        		  	Transaction transaction = new Transaction();
		        		  	Date today = new Date();
		        			Timestamp t2 = getTimestamp(today);
		        			transaction.setAccountId(accountId);
		        			transaction.setAmount(amount);
		        		  	transaction.setTransactionType("credit");
		        		  	transaction.setTransactionStatus("pending");
		        			transaction.setCreateAt(t2);
		        			
		        			Account _account = accountDAO.findOne(accountId);
		        			double tmpAmount = account.getAccountBalance();
		        			
		        			double newBalance = tmpAmount - amount;
		        			
		        			_account.setAccountBalance(newBalance);
		        			
		        			accountDAO.save(_account);
		        		  	
		        		  	Transaction _transaction = transactionDAO.save(transaction);
			        		successResponse.setCode(1000);
					  		successResponse.setStatus(true);
					  		successResponse.setResponseText(transaction.getId().toString());
					  		return successResponse;
		        	  }
		        	  
		    
		          }
			}
			
			successResponse.setCode(1001);
			successResponse.setStatus(false);
			successResponse.setResponseText("Invalid Account Details..!");
			return successResponse;
		}
		
		@PostMapping("/accounts/updatePayment")
		public SuccessResponse updateAccountsPayment(@Valid @RequestBody UpdatePaymentTransaction updatePaymentTransaction){
			
			SuccessResponse successResponse = new SuccessResponse();
			
			Transaction transaction = transactionDAO.findOne(updatePaymentTransaction.getTransactionId());
			Account account = accountDAO.findOne(transaction.getAccountId());
			
			if(updatePaymentTransaction.getTransactionType().equalsIgnoreCase("debit")) {
				transaction.setTransactionStatus("reject");
				transactionDAO.save(transaction);
				
    			double tmpAmount = account.getAccountBalance();
    			double newBalance = tmpAmount + transaction.getAmount();
    			account.setAccountBalance(newBalance);
    			
    			accountDAO.save(account);
				System.out.print("fhvjh hjvjhvjh");
				successResponse.setCode(1000);
				successResponse.setStatus(true);
				successResponse.setResponseText("Success..!");
				return successResponse;
			}
			
			successResponse.setCode(1001);
			successResponse.setStatus(false);
			successResponse.setResponseText("Invalid Account Details..!");
			return successResponse;
			
		}
		

		public static Timestamp getTimestamp(Date date) { return date == null ? null : new java.sql.Timestamp(date.getTime()); }

		/*get account by accountid*/
		@GetMapping("/accounts/{id}")
		public ResponseEntity<Account> getAccountById(@PathVariable(value="id") Long accountid){
			
			Account account= accountDAO.findOne(accountid);
			
			if(account==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(account);
			
		}
		
		/*update an account by accountid*/
		@PutMapping("/accounts/{id}")
		public ResponseEntity<Account> updateAccount(@PathVariable(value="id") Long accountid,@Valid @RequestBody Account accountDetails){
			
			Account account=accountDAO.findOne(accountid);
			if(account==null) {
				return ResponseEntity.notFound().build();
			}
			
			account.setFname(accountDetails.getFname());
			account.setLname(accountDetails.getLname());
			account.setAccountBalance(accountDetails.getAccountBalance());
			account.setCardNo(accountDetails.getCardNo());
			account.setCvc(accountDetails.getCvc());
			account.setAccountStatus(accountDetails.getAccountStatus());
			
			Account updateAccount=accountDAO.save(account);
			return ResponseEntity.ok().body(updateAccount);
			
			
		}
		
		/*Delete an account*/
		@DeleteMapping("/accounts/{id}")
		public ResponseEntity<Account> deleteEmployee(@PathVariable(value="id") Long accountid){
			
			Account account = accountDAO.findOne(accountid);
			if(account==null) {
				return ResponseEntity.notFound().build();
			}
			accountDAO.delete(account);
			
			return ResponseEntity.ok().build();
			
			
		}
}
