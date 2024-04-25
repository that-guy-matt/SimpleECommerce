package com.ecommerce.orders;

import java.util.ArrayList;
import java.util.List;
import com.ecommerce.*;

/**
 * The Order class represents an order created by a customer.
 * Each order has a unique ID, a customer, a list of products, a total amount, and a status.
 */
public class Order {
	private static List<Order> orderList = new ArrayList<>();
	
	private static int nextOrderId = 1;
	private int orderID;
	private Customer customer;
	private ArrayList<Product> products;
	private double orderTotal;
	private String orderStatus;

	// Constructor
	public Order(Customer customer) {
		this.orderID = nextOrderId++;
		this.customer = customer;
		this.products = new ArrayList<>();
		this.orderTotal = 0.0;
		this.orderStatus = "Pending";
		orderList.add(this);
	}
	
	// Getters
	public int getOrderID() {
		return orderID;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public double getOrderTotal() {
		return orderTotal;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	// Setters
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	// Utility methods
	public void addProduct(Product product) {
		products.add(product);
		orderTotal += product.getPrice();
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
		orderTotal -= product.getPrice();
	}

	/**
     * Generates a summary of the order, including order ID, customer name, products, total amount, and status.
     * 
     * @return A string containing the order summary.
     */
	public String generateOrderSummary() {
		StringBuilder summary = new StringBuilder();
		summary.append("\nOrder ID: ").append(orderID).append("\n");
		summary.append("Customer: ").append(customer.getName()).append("\n");
		summary.append("Products: \n");
		for (Product product : products) {
			summary.append("- ").append(product.getName()).append(": $").append(product.getPrice()).append("\n");
		}
		summary.append("Order Total: $").append(orderTotal).append("\n");
		summary.append("Order status: ").append(orderStatus).append("\n\n");
		
		return summary.toString();
	}
	
	/**
     * Displays all orders in the order list.
     */
	public void displayOrders() {
		for (Order order : orderList) {
			System.out.print(order.generateOrderSummary());
		}
	}
}
