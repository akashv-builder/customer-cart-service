package com.kkd.customercartservice.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cartInformation")
//@ApiModel(description="All details about the user. ")
public class CustomerCartDetails {

	@Id
	private String cartItemId;
	
	private String kkkdFarmID;
	
	private String farmerName;
	
	private String productId;
		
	private String productName;
	
	private double productPrice;
	
	private double avgRating;
	
	private double quantity;
	
	public CustomerCartDetails(String cartItemId, String kkkdFarmID, String farmerName, String productId,
			String productName, double productPrice, double avgRating, double quantity) {
		super();
		this.cartItemId = cartItemId;
		this.kkkdFarmID = kkkdFarmID;
		this.farmerName = farmerName;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.avgRating = avgRating;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "CustomerCartDetails [cartItemId=" + cartItemId + ", kkkdFarmID=" + kkkdFarmID + ", farmerName="
				+ farmerName + ", productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", avgRating=" + avgRating + ", quantity=" + quantity + "]";
	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public String getKkkdFarmID() {
		return kkkdFarmID;
	}

	public void setKkkdFarmID(String kkkdFarmID) {
		this.kkkdFarmID = kkkdFarmID;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}	
}