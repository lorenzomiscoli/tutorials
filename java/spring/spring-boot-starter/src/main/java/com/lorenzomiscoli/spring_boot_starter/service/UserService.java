package com.lorenzomiscoli.spring_boot_starter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lorenzomiscoli.spring_boot_starter.exception.UserMismatchException;
import com.lorenzomiscoli.spring_boot_starter.exception.UserNotFoundException;
import com.lorenzomiscoli.spring_boot_starter.model.User;
import com.lorenzomiscoli.spring_boot_starter.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public User update(User user, Long id) {
		if (user.getId() != id) {
			throw new UserMismatchException();
		}
		findById(id);
		return userRepository.save(user);
	}

	public void delete(Long id) {
		findById(id);
		userRepository.deleteById(id);
	}

}
