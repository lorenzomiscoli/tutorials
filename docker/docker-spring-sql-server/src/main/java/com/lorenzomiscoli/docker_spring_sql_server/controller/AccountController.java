package com.lorenzomiscoli.docker_spring_sql_server.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzomiscoli.docker_spring_sql_server.entities.Account;
import com.lorenzomiscoli.docker_spring_sql_server.service.AccountService;

@RestController
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(value = "/accounts")
	public ResponseEntity<List<Account>> findAll() {
		return ResponseEntity.ok(accountService.findAll());
	}

}
