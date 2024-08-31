package com.shakib1729.stocks_api.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private final UserRepository repository;

	public UserController(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping("/user")
	public ResponseEntity<UserResponse> getUser() {
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = repository.findByEmail(userEmail).orElseThrow();

		UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getBalance(),
				user.getStocks());

		return ResponseEntity.ok(userResponse);

	}

}
