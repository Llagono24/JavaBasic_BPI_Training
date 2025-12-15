package m3.act2;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class M3_Activity2 {
	
	//global hashset 
	static Set<String> productSet = new HashSet<>();

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		Integer choice;
		
		//Adding products 
		productSet.add("Laptop");
		productSet.add("Monitor");
		productSet.add("Mousepad");
		productSet.add("Keyboard");
		productSet.add("Printer");
		
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
				System.out.println("Exiting...");
			}else {
				System.out.println("Invalid Input!");
			}
			
		}while (choice != 4);
		
		input.close();
	}
	
	//Display menu method
	static Integer displayMenu(Scanner input) {
		System.out.println("Select an option: ");
		System.out.println("1. Search a product");
		System.out.println("2. Add a product");
		System.out.println("3. Print all products and count");
		System.out.println("4. Exit");
		System.out.print(">");
		
		Integer choice = input.nextInt();
		
		return choice;
		
	}
	
	//search product method
	static void searchProduct(Scanner input) {
		System.out.print("Enter a product name to search: ");
		input.nextLine();
		String name = input.nextLine();
		
		if(productSet.contains(name)) {
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
		
		if(productSet.contains(name)) {
			System.out.println("Product already in the list");
		}else {
			productSet.add(name);
			System.out.println("Product added: "+name);
		}


	}
	
	//print product method
	static void printAllProducts() {
		System.out.println("All products: ");
		for(String product : productSet) {
			System.out.println(product);
		}
		System.out.println("Total unique products: "+productSet.size());

	}
	

}
