package com.user.application.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.user.application.dto.OrderRequestDTO;
import com.user.application.entity.CustomerDetails;
import com.user.application.service.UserService;


@RestController
public class OrderController {
	@Autowired
	private UserService userService;
	@PostMapping("/placeOrder")
	public ResponseEntity<CustomerDetails> placeOrder(@RequestBody OrderRequestDTO request)
	{
		ResponseEntity<CustomerDetails> customerDetails=null;
		try {
		return new ResponseEntity<CustomerDetails>(userService.saveCustomer(request.getCustomerDetails()), HttpStatus.CREATED);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return customerDetails;
	}
}