package com.user.application.dto;
import com.user.application.entity.CustomerDetails;

public class OrderRequestDTO 
{
	private CustomerDetails customer;
    public CustomerDetails getCustomerDetails() {
		return customer;
	}
	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}
}
