package com.masaischool.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String address;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Authority> authority = new ArrayList<>();
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String email, String password, String address, List<Authority> authority) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.authority = authority;
	}

	public Integer getCustId() {
		return custId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}
}
