package com.shakib1729.stocks_api.stocks;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.shakib1729.stocks_api.user.User;
import com.shakib1729.stocks_api.user.UserRepository;

@Service
public class StocksService {

	private final UserRepository repository;

	public StocksService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	public String updateStocksAndBalance(UpdateStocksAndBalanceRequest request) {
		// Get the currently logged in user
		String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = repository.findByEmail(userEmail).orElseThrow();

		// Update the fields for this user as per the request
		user.setStocks(request.getStocks());
		user.setBalance(request.getBalance());

		// Save the user in repository
		repository.save(user);

		return "Done!";
	}

}
