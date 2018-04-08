package com.kkd.customercartservice.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kkd.customercartservice.modal.CustomerCartDetails;
import com.kkd.customercartservice.service.CustomerCartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/customer/user")
public class CustomerCartController {
	
	@Autowired
	CustomerCartService customerCartService;
	
	@GetMapping("/{customer_id}")
	@HystrixCommand(fallbackMethod = "ifgetAllCartItemInformationsFails")
	public List<CustomerCartDetails> getAllCartItemInformation() {
		return customerCartService.getAllCartItemInformation();
	}
	
	
	public List<CustomerCartDetails> ifgetAllCartItemInformationsFails() {
		return Arrays.asList(new CustomerCartDetails("default", "default", "default", "default", "default", 0, 0, 0));
	}

	@PostMapping("/{customer_id}")
	@HystrixCommand(fallbackMethod = "ifaddItemInCartFails")
	// adding validation using @valid
	public ResponseEntity<Object> addItemInCart(@Valid @RequestBody CustomerCartDetails dataOfUserInBody) {
		customerCartService.addItemInCart(dataOfUserInBody);
		// this is added to give a response that the uri that is going to be created is
		// successfully created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dataOfUserInBody.getCartItemId()).toUri();
		return ResponseEntity.created(location).build();
	}

	public ResponseEntity<Object> ifaddItemInCartFails(@Valid @RequestBody CustomerCartService dataOfUserInBody) {
		return null;
	}
	
	@DeleteMapping("/cart/{cart_item_id}")
	@HystrixCommand(fallbackMethod="ifdeleteItemFromCartFails")
	public String deleteItemFromCart(@PathVariable String id) {
		customerCartService.deleteItemFromCart(id);
		return "cart Item deleted";
	}

	public String ifdeleteItemFromCartFails() {
		return "Cannot Delete Item";
	}
}
