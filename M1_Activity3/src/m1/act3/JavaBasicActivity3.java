/**
 * 
 */
package m1.act3;
import java.util.Scanner;
/**
 * 
 */
public class JavaBasicActivity3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputNum = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int num1 = inputNum.nextInt();
		System.out.print("Enter second integer: ");
		int num2 = inputNum.nextInt();
		inputNum.close();
		System.out.println("Sum: "+Sum(num1, num2));
		System.out.println("Difference: "+Difference(num1, num2));
		System.out.println("Product: "+Product(num1, num2));
	}
	
	public static int Sum(int num1, int num2) {
		int sum = num1+num2;	
		return sum;
	}
	
	public static int Difference(int num1, int num2) {
		int diff = num1-num2;	
		return diff;
	}
	
	public static int Product(int num1, int num2) {
		int product = num1*num2;	
		return product;
	}


}
