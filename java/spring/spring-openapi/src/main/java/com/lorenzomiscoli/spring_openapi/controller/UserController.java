package com.lorenzomiscoli.spring_openapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzomiscoli.spring_openapi.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "Users")
public class UserController {

	@GetMapping
	@Operation(summary = "Get all users")
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(List.of());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get a user by id")
	public ResponseEntity<User> findById(@PathVariable int id) {
		return ResponseEntity.ok(new User());
	}

	@PostMapping
	@Operation(summary = "Insert a user")
	public ResponseEntity<User> insert(@RequestBody User user) {
		return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update a user")
	public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a user by id")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		return ResponseEntity.noContent().build();
	}

}
