package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.model.Account;
import com.paf.repository.account.AccountRepository;

@Service
public class AccountDAO {
	@Autowired
	AccountRepository accountRepository;
	
	/*to save an account*/
	
	public Account save(Account account) {
		return accountRepository.save(account);
	}
	
	
	/* search all accounts*/
	
	public List<Account> findAll(){
		return accountRepository.findAll();
	}
	
	
	/*get an account by id*/
	public Account findOne(Long accountid) {
		return accountRepository.findOne(accountid);
	}
	
	
	/*delete an account*/
	
	public void delete(Account account) {
		accountRepository.delete(account);
	}
}
