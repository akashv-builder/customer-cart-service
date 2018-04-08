package com.kkd.customercartservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkd.customercartservice.exception.CartItemNotFoundException;
import com.kkd.customercartservice.modal.CustomerCartDetails;
import com.kkd.customercartservice.repository.CustomerCartRepository;

@Service
public class CustomerCartService {
		
	@Autowired
	CustomerCartRepository customerCartRepository;
	
	public List<CustomerCartDetails> getAllCartItemInformation() {
		List<CustomerCartDetails> allUsersFound = new ArrayList<>();
		customerCartRepository.findAll().forEach(allUsersFound::add);
		return allUsersFound;
	}

	public Optional<CustomerCartDetails> getcartItemInformation(String id) {
		 Optional<CustomerCartDetails> userFound=customerCartRepository.findById(id);
		 //if not found creating a custom exception and generating the http code 
		 //checking if object is null throw exception
		 if(!userFound.isPresent()) {
			 throw new CartItemNotFoundException("id-"+id);
		 }
		 return userFound;
	}

	public void addItemInCart(CustomerCartDetails dataOfUserInBody) {
		customerCartRepository.save(dataOfUserInBody);

	}

	public void deleteItemFromCart(String id) {
		 Optional<CustomerCartDetails> userFound=customerCartRepository.findById(id);
		 //if not found creating a custom exception and generating the http code		 
		 //checking if object is null throw exception
		 if(!userFound.isPresent()) {
			 throw new CartItemNotFoundException("id-"+id);
		 }
		 customerCartRepository.deleteById(id);
	}

}