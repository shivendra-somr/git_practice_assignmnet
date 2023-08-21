package com.masaischool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.entity.Authority;
import com.masaischool.entity.Customer;
import com.masaischool.exception.CustomerException;
import com.masaischool.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) {
		//this is important
		List<Authority> authorities= customer.getAuthority();
		
		//associating each authority with customer
		for(Authority authority:authorities) {
			authority.setCustomer(customer);
		}
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		Optional<Customer> customer = customerRepository.findByEmail(email);
		return customer.orElseThrow(() -> new CustomerException("No customer found for email " + email));
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		List<Customer> list = customerRepository.findAll();
		if(list.isEmpty())
			throw new CustomerException("No Customer Found");
		return list;
	}
}
