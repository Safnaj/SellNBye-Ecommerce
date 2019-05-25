package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.model.Transaction;
import com.paf.repository.account.TransactionRepository;

@Service
public class TransactionDAO {

	@Autowired
	TransactionRepository transactionRepository;
	
	/*to save an transaction*/
	
	public Transaction save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	
	/* search all transactions*/
	
	public List<Transaction> findAll(){
		return transactionRepository.findAll();
	}
	
	
	/*get an transaction by id*/
	public Transaction findOne(Long transactionid) {
		return transactionRepository.findOne(transactionid);
	}
	
	
	/*delete an transaction*/
	
	public void delete(Transaction transaction) {
		transactionRepository.delete(transaction);
	}
}
