package simpleECommerce;

import textio.TextIO;
import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.MenuSystem;
import com.ecommerce.orders.Order;

public class simpleECommerce {
	
	public static void main(String[] args) {
		
		// Create some sample products
		Product product1 = new Product("Apple", 1.99);
        Product product2 = new Product("Banana", 0.99);
        Product product3 = new Product("Orange", 1.49);
        Product product4 = new Product("Milk", 2.49);
        Product product5 = new Product("Bread", 1.79);
        Product product6 = new Product("Eggs", 2.99);
        Product product7 = new Product("Chicken", 5.99);
        Product product8 = new Product("Rice", 3.49);
        Product product9 = new Product("Potatoes", 0.79);
        Product product10 = new Product("Pasta", 1.29);
        
		System.out.println("Welcome to the eCommerce app.");
		System.out.print("What is your name: ");
		String customerName = TextIO.getlnString();
		Customer customer = new Customer(customerName);
		Order order = new Order(customer);
		MenuSystem menuSystem = new MenuSystem(customer, order);
		
		menuSystem.displayMenu();
	}
	
}