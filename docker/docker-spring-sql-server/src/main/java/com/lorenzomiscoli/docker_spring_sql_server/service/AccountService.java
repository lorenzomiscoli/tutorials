package com.lorenzomiscoli.docker_spring_sql_server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lorenzomiscoli.docker_spring_sql_server.entities.Account;
import com.lorenzomiscoli.docker_spring_sql_server.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepo;

	public AccountService(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}

	public List<Account> findAll() {
		return this.accountRepo.findAll();
	}
	
}
