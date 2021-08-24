package com.user.application.dto;
public class OrderResponseDTO {
    private int productId;
    private String productName;
    private String productLevel;
    private int premium;
    
    public OrderResponseDTO(int productId, String productName, String productLevel, int premium)
    {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productLevel = productLevel;
		this.premium = premium;
	}
     public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLevel() {
		return productLevel;
	}

	public void setProductLevel(String productLevel) {
		this.productLevel = productLevel;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}   
}



