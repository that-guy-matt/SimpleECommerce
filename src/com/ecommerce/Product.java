package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

/**
 * The Product class represents a product available for purchase in the e-commerce system.
 * Each product has a unique ID, a name, and a price.
 */
public class Product {
	private static List<Product> productList = new ArrayList<>();
	
	private static int nextProductId = 1;
	private int productID;
	private String name;
	private double price;
	
	// Constructor
	public Product(String name, double price) {
		this.productID = nextProductId++;
		this.name = name;
		this.price = price;
		productList.add(this);
	}
	
	// Getters
	public int getProductID() {
		return productID;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	
	// Setters
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
     * Displays the details of all available products.
     */
	public static void displayProducts() {
		System.out.println("Products:");
		for (Product product : productList) {
			System.out.println("Product ID: " + product.getProductID());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: $" + product.getPrice());
			System.out.println();
		}
	}
	
	/**
     * Returns the product with the specified ID.
     * 
     * @param id The ID of the product to be retrieved.
     * @return The product with the specified ID, or null if not found.
     */
	public static Product getProductById(int id) {
		for (Product product : productList) {
			if (product.getProductID() == id) {
				return product;
			}
		}
		return null;
	}
	
	/**
     * Checks if a product with the specified ID exists.
     * 
     * @param id The ID of the product to be checked.
     * @return true if the product exists, false otherwise.
     */
	public static boolean productExists(int id) {
		if (Product.getProductById(id) != null) {
			return true;			
		} else {
			return false;
		}
	}
}
