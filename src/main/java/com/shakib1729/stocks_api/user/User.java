package com.shakib1729.stocks_api.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shakib1729.stocks_api.stocks.StockWithQuantity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "_user")
@SuppressWarnings("serial")
public class User implements UserDetails {

	protected User() {
	}

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true)
	private String email;

	private String name;
	private String password;
	private double balance;

	@ElementCollection
	@CollectionTable(name = "user_stocks", joinColumns = @JoinColumn(name = "user_id"))
	private List<StockWithQuantity> stocks;

	public User(String name, String email, String password, Role role, double balance) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.balance = balance;
	}

	@Enumerated(EnumType.STRING)
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		return email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<StockWithQuantity> getStocks() {
		return stocks;
	}

	public void setStocks(List<StockWithQuantity> stocks) {
		this.stocks = stocks;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", balance="
				+ balance + ", stocks=" + stocks + ", role=" + role + "]";
	}

}
