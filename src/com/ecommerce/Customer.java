package com.ecommerce;

import java.util.ArrayList;
import java.util.List;
import com.ecommerce.orders.Order;

public class Customer {
	private static List<Customer> customerList = new ArrayList<>();
	
	private static int nextCustomerId = 1;
	private int customerID;
	private String name;
	private ArrayList<Product> shoppingCart;
	
	// Constructor
	public Customer(String name) {
		this.customerID = nextCustomerId++;
		this.name = name;
		this.shoppingCart = new ArrayList<>();
		customerList.add(this);
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
	
	public boolean isProductInCart(int id) {
		if (Product.getProductById(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void displayCart() {
		System.out.println("\nCart:");
		for (Product product : shoppingCart) {
	        System.out.println("Product ID: " + product.getProductID());
	        System.out.println("Name: " + product.getName());
	        System.out.println("Price: $" + product.getPrice());
	        System.out.println();
	    }
	}
	
	// TODO remove if not used
//	public void generateOrder() {
//		Order order = new Order(this);
//		for (Product product : shoppingCart) {
//			order.addProduct(product);			
//		}
//	}
}
