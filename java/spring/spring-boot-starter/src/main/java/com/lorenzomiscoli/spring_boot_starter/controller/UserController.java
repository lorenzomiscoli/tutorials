package com.lorenzomiscoli.spring_boot_starter.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lorenzomiscoli.spring_boot_starter.model.User;
import com.lorenzomiscoli.spring_boot_starter.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("/username/{username}")
	public ResponseEntity<User> findByUsername(@PathVariable String username) {
		return ResponseEntity.ok(userService.findByUsername(username));
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		User newUser = userService.insert(user);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(loc).body(newUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
		return ResponseEntity.ok(userService.update(user, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
