package com.user.application.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.user.application.dto.OrderResponseDTO;
//import com.user.application.repository.CustomerRepository;
//import com.user.application.repository.ProductRepository;
import com.user.application.service.UserService;

@RestController
public class EligibleProductsController 
{
	@Autowired
	private UserService userservice;
	@GetMapping("/getInfo//{id}")
	public ResponseEntity<List<OrderResponseDTO>> getSubscribedProducts(@PathVariable int id)
	{
		try {
			return new ResponseEntity<List<OrderResponseDTO>>(userservice.getSubscribedProducts(id),HttpStatus.OK);
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@GetMapping("/getOnlyEligibleProducts/{id}")
	public ResponseEntity<List<OrderResponseDTO>> getOnlyEligibleProducts(@PathVariable int id)
	{
		return new ResponseEntity<List<OrderResponseDTO>>(userservice.getOnlyEligibleProducts(id), HttpStatus.OK);
	}
}