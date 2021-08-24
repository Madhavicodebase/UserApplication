package com.user.application.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.application.entity.CustomerDetails;
//import com.user.application.repository.CustomerRepository;
//import com.user.application.repository.ProductRepository;
import com.user.application.service.UserService;

@RestController
public class FindOrdersController
{
	@Autowired
	private UserService userservice;
	@GetMapping("/findAllOrders")
	public List<CustomerDetails> findAllOrders()
	{
		try {
		return userservice.getCustomers();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}