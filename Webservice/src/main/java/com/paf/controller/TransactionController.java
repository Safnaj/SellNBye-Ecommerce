package com.paf.controller;

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

import com.paf.dao.TransactionDAO;
import com.paf.model.Transaction;

@RestController
public class TransactionController {


	  private final TransactionDAO transactionDAO;

	  @Autowired
	  TransactionController(TransactionDAO transactionDAO) {
	    this.transactionDAO = transactionDAO;
	  }
	  
		/* to save an transaction*/
		@PostMapping("/transactions")
		public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
			return transactionDAO.save(transaction);
		}
		
		/*get all transactions*/
		@GetMapping("/transactions")
		public List<Transaction> getAllTransactions(){
			return transactionDAO.findAll();
		}

		/*get transaction by transactionid*/
		@GetMapping("/transactions/{id}")
		public ResponseEntity<Transaction> getTransactionById(@PathVariable(value="id") Long transactionid){
			
			Transaction transaction= transactionDAO.findOne(transactionid);
			
			if(transaction==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(transaction);
			
		}
		
		/*update an transaction by transactionid*/
		@PutMapping("/transactions/{id}")
		public ResponseEntity<Transaction> updateTransaction(@PathVariable(value="id") Long transactionid,@Valid @RequestBody Transaction transactionDetails){
			
			Transaction transaction=transactionDAO.findOne(transactionid);
			if(transaction==null) {
				return ResponseEntity.notFound().build();
			}
			
			transaction.setAccountId(transactionDetails.getAccountId());
			transaction.setAmount(transactionDetails.getAmount());
			transaction.setTransactionType(transactionDetails.getTransactionType());
			transaction.setTransactionStatus(transactionDetails.getTransactionStatus());
			transaction.setCreateAt(transactionDetails.getCreateAt());
			
			Transaction updateTransaction=transactionDAO.save(transaction);
			return ResponseEntity.ok().body(updateTransaction);
			
			
			
		}
		
		/*Delete an transaction*/
		@DeleteMapping("/transactions/{id}")
		public ResponseEntity<Transaction> deleteEmployee(@PathVariable(value="id") Long transactionid){
			
			Transaction transaction = transactionDAO.findOne(transactionid);
			if(transaction==null) {
				return ResponseEntity.notFound().build();
			}
			transactionDAO.delete(transaction);
			
			return ResponseEntity.ok().build();
			
			
		}
}
