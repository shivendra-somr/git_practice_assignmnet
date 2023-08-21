package com.masaischool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@JsonIgnore
	@ManyToOne
	//@JoinColumn(name = "customer_id")
	private Customer customer;

	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Authority(String name, Customer customer) {
		super();
		this.name = name;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
