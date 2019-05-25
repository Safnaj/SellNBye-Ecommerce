package com.paf.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
