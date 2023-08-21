package com.masaischool.service;

import java.util.List;

import com.masaischool.entity.Customer;
import com.masaischool.exception.CustomerException;

public interface CustomerService {
	public Customer registerCustomer(Customer customer);
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException;
	public List<Customer> getAllCustomerDetails() throws CustomerException;
}
