package com.user.application.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.application.dto.OrderResponseDTO;
import com.user.application.entity.CustomerDetails;
//import com.user.application.exception.BusinessException;
import com.user.application.repository.CustomerRepository;

@Service
public class UserService 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerDetails saveCustomer(CustomerDetails customer)
	{
		try {
		return customerRepository.save(customer);
	}catch(Exception e)
		{
			System.out.println(e);
		}
		return customer;	
	}
	public List<CustomerDetails> getCustomers()
	{
		try {
		return customerRepository.findAll();
	}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	public List<OrderResponseDTO> getSubscribedProducts(int id)
	{
		try {
		return customerRepository.getSubscribedProducts(id);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	public List<OrderResponseDTO> getOnlyEligibleProducts(int id)
	{
		return customerRepository.getOnlyEligibleProducts(id);
	}
	
}
