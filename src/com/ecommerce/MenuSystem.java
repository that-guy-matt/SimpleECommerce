package com.ecommerce;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import textio.TextIO;

public class MenuSystem {
	
	private Customer customer;
	
	public MenuSystem(Customer customer) {
		this.customer = customer;
	}
	
	public void displayMenu() {
		
		int choice;
		do {
			System.out.println("===== Menu =====");
			System.out.println("1. View products");
			System.out.println("2. Add product to cart");
			System.out.println("3. Remove product from cart");
			System.out.println("4. Show cart");
			System.out.println("5. Show order");
			System.out.println("6. Place order");
			System.out.println("7. exit");
			System.out.print("\nEnter your selection: ");
			choice = TextIO.getInt();
					
			switch (choice) {
			case 1:
				Product.displayProducts();
				break;
			case 2:
				System.out.print("Please enter product ID number that you would like to add: ");
				choice = TextIO.getInt();
				customer.addToCart(Product.getProductById(2));
				customer.addToCart(Product.getProductById(5));
				break;
			case 4:
				customer.displayCart();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.println("Exiting application...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please enter a single digit.");
			}
		} while (choice != 7);
		
	}
	
	// Utility methods

}
