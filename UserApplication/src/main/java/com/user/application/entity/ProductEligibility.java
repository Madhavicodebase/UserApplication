package com.user.application.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class ProductEligibility 
{
	@Id
	private int customerId;
	private int productId ;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}

