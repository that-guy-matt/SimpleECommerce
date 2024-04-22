package com.ecommerce;

import java.util.ArrayList;

public class Customer {
	private int customerID;
	private String name;
	private ArrayList<Product> shoppingCart;
	
	// Constructor
	public Customer(int customerID, String name) {
		this.customerID = customerID;
		this.name = name;
		this.shoppingCart = new ArrayList<>();
	}
	
	// Getters
	public int getCustomerID() {
		return customerID;	
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Product> getShoppingCart() {
		return shoppingCart;
	}
	
	// Setters
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Utility methods
	public void addToCart(Product product) {
		shoppingCart.add(product);
	}
	
	public void removeFromCart(Product product) {
		shoppingCart.remove(customerID);
	}
}
