package com.user.application.entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue
    private int customerId;
    private String customerName;
    private int age;
    private String phoneNumber;
    
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<ProductDetails> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDetails> products) {
		this.products = products;
	}
	public List<PaymentMethod> getPayments() {
		return payments;
	}
	public void setPayments(List<PaymentMethod> payments) {
		this.payments = payments;
	}
	@OneToMany(targetEntity = ProductDetails.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="productId",referencedColumnName = "customerId")
    private List<ProductDetails> products;
    @OneToMany(targetEntity = PaymentMethod.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="paymentId",referencedColumnName = "customerId")
    private List<PaymentMethod> payments;
}
