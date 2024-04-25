package com.ecommerce;

import com.ecommerce.orders.Order;
import textio.TextIO;

/**
 * The MenuSystem class represents the menu system of the e-commerce application.
 * It allows customers to interact with products, add or remove them from the cart, view the cart, and place orders.
 */
public class MenuSystem {
	
	private Customer customer;
	private Order order;
	
	public MenuSystem(Customer customer, Order order) {
		this.customer = customer;
		this.order = order;
	}
	
	/**
     * Displays the main menu of the e-commerce application.
     * Allows customers to choose from various options such as viewing products, adding/removing products from the cart, and placing orders.
     */
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
				if (Product.productExists(choice) != false) {
					customer.addToCart(Product.getProductById(choice));
					order.addProduct(Product.getProductById(choice));
					System.out.println("Added " + Product.getProductById(choice).getName() + " to cart.\n");
				} else {
					System.out.println("That product doesn't seem to exist. Try again.\n");
				}
				break;
				
			case 3:
				System.out.print("Please enter product ID number that you would like to remove: ");
				choice = TextIO.getInt();
				if (customer.isProductInCart(choice) != false) {
					customer.removeFromCart(Product.getProductById(choice));
					order.removeProduct(Product.getProductById(choice));
					System.out.println("removed " + Product.getProductById(choice).getName() + " from cart.\n");
				} else {
					System.out.println("That product isn't in your cart.\n");
				}
				break;
				
			case 4:
				customer.displayCart();
				break;
				
			case 5:
				order.displayOrders();
				break;
				
			case 6:
				order.setOrderStatus("Placed");
				System.out.println("Order successfully placed. You may start a new order.\n");
				customer.emptyCart();
				Order newOrder = new Order(customer);
				MenuSystem newMenu = new MenuSystem(customer, newOrder);
				newMenu.displayMenu();
				
			case 7:
				System.out.println("Exiting application...");
				System.exit(0);
				
			default:
				System.out.println("Invalid choice. Please enter a single digit.");
			}
		} while (choice != 7);
		
	}

}
