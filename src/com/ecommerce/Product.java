package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

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
	
	// Utility methods
	public static void displayProducts() {
		System.out.println("Products:");
		for (Product product : productList) {
			System.out.println("Product ID: " + product.getProductID());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: $" + product.getPrice());
			System.out.println();
		}
	}
	
	public static Product getProductById(int id) {
		for (Product product : productList) {
			if (product.getProductID() == id) {
				return product;
			}
		}
		return null;
	}
	
	public static Product productExists(int id) {
		Product product = Product.getProductById(id);
		if (product != null) {
			return product;			
		} else {
			System.out.println("That product doesn't seem to exist. Try again.\n");
			return null;
		}
	}
}
