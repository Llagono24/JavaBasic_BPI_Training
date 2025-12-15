package m3.act1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M3_Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		List<String> products = new ArrayList<String>();
		
		products.add("Laptop");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Monitor");
		products.add("Printer");
		
		System.out.println("Displaying all products before adding and removing product");
		for(int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}
		System.out.println("\n");
		
		products.add("Webcam");
		products.remove(1);
		
		System.out.println("Displaying all products after adding and removing product");
		for(int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}
		
		System.out.println("\n");
		System.out.print("Enter the product you want to search: ");
		String product = input.nextLine();
		
		if(products.contains(product)) {
			System.out.print("Product found: "+product);
		}else {
			System.out.print("Product not found");
		}
		
		
		

	}

}
