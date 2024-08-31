package com.shakib1729.stocks_api.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AppController {

	@GetMapping
	public ResponseEntity<String> sayeHello() {
		return ResponseEntity.ok("Hello from a secured endpoint!");
	}

}
