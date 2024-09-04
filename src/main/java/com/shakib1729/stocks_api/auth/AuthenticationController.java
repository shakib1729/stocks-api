package com.shakib1729.stocks_api.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

	private final AuthenticationService service;
	private final String DEV_ENVIRONMENT = "DEV";

	@Value("${application.security.jwt.expiration}")
	private long jwtExpiration;

	@Value("${application.environment}")
	private String env;

	private String getCookieStringified(String value, long maxAgeSeconds) {

		// https://stackoverflow.com/a/64384774
		if (DEV_ENVIRONMENT.equals(env)) {
			return ResponseCookie.from("jwtToken", value).httpOnly(true).sameSite("Strict").secure(false).path("/")
					.maxAge(maxAgeSeconds).build().toString();
		}

		return ResponseCookie.from("jwtToken", value).httpOnly(true).sameSite("None").secure(true).path("/")
				.maxAge(maxAgeSeconds).build().toString();

	}

	public AuthenticationController(AuthenticationService service) {
		this.service = service;
	}

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request,
			HttpServletResponse response) {
		AuthenticationResponse authenticationResponse = service.authenticate(request);
		response.addHeader(HttpHeaders.SET_COOKIE,
				getCookieStringified(authenticationResponse.getToken(), jwtExpiration / 1000));

		return ResponseEntity.ok(authenticationResponse);
	}

	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpServletResponse response) {
		response.addHeader(HttpHeaders.SET_COOKIE, getCookieStringified(null, 0));
		return ResponseEntity.ok("Logged Out!");
	}

}
