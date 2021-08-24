package com.user.application.entity;
import javax.persistence.*;

@Entity
public class ProductSubscription {
    @Id
    @GeneratedValue
    private int productSubsId;
    private int customerId;
    private int productId;
    private int paymentId;
	public int getProductSubsId() {
		return productSubsId;
	}
	public void setProductSubsId(int productSubsId) {
		this.productSubsId = productSubsId;
	}
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
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
}
