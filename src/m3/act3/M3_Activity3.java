package m3.act3;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class M3_Activity3 {
	
	
	static Map<String, Integer> productsMap = new HashMap<>();
	
	
	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		Integer choice;
		
		productsMap.put("Laptop", 25000);
		productsMap.put("Monitor", 10000);
		productsMap.put("Mousepad", 200);
		productsMap.put("Keyboard", 999);
		productsMap.put("Printer", 20000);
		
		
		
		// Main app looping menu until exit
		do {
			choice = displayMenu(input);
			if(choice == 1) {
				searchProduct(input);
			}else if(choice == 2) {
				addProduct(input);
			}else if(choice == 3) {
				printAllProducts();
			}else if(choice == 4) {
				findCheapestProduct();
			}else if(choice == 4) {
				System.out.println("Exiting...");
			}else {
				System.out.println("Invalid Input!");
			}
			
		}while (choice != 5);
		
		
		input.close();
	}
	
	

	//Display menu method
	static Integer displayMenu(Scanner input) {
		System.out.println("Select an option: ");
		System.out.println("1. Search a product");
		System.out.println("2. Add a product");
		System.out.println("3. Print all products and prices");
		System.out.println("4. Find the cheapest products");
		System.out.println("5. Exit");
		System.out.print(">");
		
		Integer choice = input.nextInt();
		
		return choice;
		
	}
	
	//search product method
	static void searchProduct(Scanner input) {
		System.out.print("Enter a product name to search: ");
		input.nextLine();
		String name = input.nextLine();
		
		if(productsMap.containsKey(name)) {
			System.out.println("Product found: "+name);
		}else {
			System.out.println("Product not found");
		}
	}
	
	//add product method
	static void addProduct(Scanner input) {
		System.out.print("Enter a product name to add: ");
		input.nextLine();
		String name = input.nextLine();
		System.out.print("Enter a price: ");
		Integer price = input.nextInt();
		
		
		if(productsMap.containsKey(name)) {
			System.out.println("Product already in the list");
		}else {
			productsMap.put(name, price);
			System.out.println("Product added: "+name);
		}


	}
	
	//print product method
	static void printAllProducts() {
		System.out.println("All products: ");
		for(Map.Entry<String, Integer> entry : productsMap.entrySet()) {
			System.out.println(entry.getKey() + " - " +entry.getValue());
		}
		System.out.println("Total products: "+productsMap.size());

	}
	
	//find cheapest product
	static void findCheapestProduct() {
		Map.Entry<String, Integer> minEntry = null;
		for(Map.Entry<String, Integer> entry : productsMap.entrySet()) {

	        if (minEntry == null || entry.getValue() < minEntry.getValue()) {
	            	minEntry = entry;
		        }

		}
	    if (minEntry != null) {
	    	System.out.println("Cheapest product: "+minEntry.getKey() +" - " +minEntry.getValue());
	    	
	    } else {
	        System.out.println("Map is empty.");
	    }
	}
}
