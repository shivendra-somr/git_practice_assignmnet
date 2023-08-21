package com.masaischool.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masaischool.entity.Authority;
import com.masaischool.entity.Customer;
import com.masaischool.repository.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> opt= customerRepository.findByEmail(username);
		
		if(!opt.isPresent())
			throw new BadCredentialsException("User Details not found with this username: "+username);
		
		Customer customer = opt.get();
		
		//get the authorities of the customer
		List<Authority> auths = customer.getAuthority();
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (Authority auth : auths) {
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(auth.getName());
			authorities.add(sga);
		}
		
		return new User(customer.getName(), customer.getPassword(), authorities);
	}

}