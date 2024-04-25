package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

/**
 * The Customer class represents a customer in the e-commerce system.
 * Each customer has a unique ID, a name, and a shopping cart where they can add and remove products.
 */
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
	
	/**
     * Checks if a product with the given ID is present in the customer's shopping cart.
     * 
     * @param id The ID of the product to be checked.
     * @return true if the product is present in the shopping cart, false otherwise.
     */
	public boolean isProductInCart(int id) {
		if (Product.getProductById(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
     * Displays the contents of the customer's shopping cart.
     */
	public void displayCart() {
		System.out.println("\nCart:");
		for (Product product : shoppingCart) {
	        System.out.println("Product ID: " + product.getProductID());
	        System.out.println("Name: " + product.getName());
	        System.out.println("Price: $" + product.getPrice());
	        System.out.println();
	    }
	}
	
	/**
     * Empties the customer's shopping cart by removing all products.
     */
	public void emptyCart() {
		shoppingCart.clear();
	}
}
