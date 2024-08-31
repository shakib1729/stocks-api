package com.shakib1729.stocks_api.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shakib1729.stocks_api.config.JwtService;
import com.shakib1729.stocks_api.user.Role;
import com.shakib1729.stocks_api.user.User;
import com.shakib1729.stocks_api.user.UserRepository;

@Service
public class AuthenticationService {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService,
			AuthenticationManager authenticationManager) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	public AuthenticationResponse register(RegisterRequest request) {
		User user = new User(request.getName(), request.getEmail(), passwordEncoder.encode(request.getPassword()),
				Role.USER, request.getBalance());

		repository.save(user);

		String jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse(jwtToken);
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		User user = repository.findByEmail(request.getEmail()).orElseThrow();
		String jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse(jwtToken);
	}

}
