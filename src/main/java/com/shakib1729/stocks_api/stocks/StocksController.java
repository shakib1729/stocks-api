package com.shakib1729.stocks_api.stocks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StocksController {

	private final StocksService service;

	public StocksController(StocksService service) {
		super();
		this.service = service;
	}

	@PostMapping("/updateStocksAndBalance")
	public ResponseEntity<String> updateStocksAndBalance(@RequestBody UpdateStocksAndBalanceRequest request) {

		return ResponseEntity.ok(service.updateStocksAndBalance(request));
	}

}
