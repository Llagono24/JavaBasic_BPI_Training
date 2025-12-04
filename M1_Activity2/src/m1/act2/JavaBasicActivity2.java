/**
 * 
 */
package m1.act2;
import java.util.Scanner;

/**
 * 
 */
public class JavaBasicActivity2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String age;
		
		System.out.print("Enter your age: ");
		Scanner inputAge = new Scanner(System.in);
		age = inputAge.nextLine();
		inputAge.close();
		int intAge = Integer.parseInt(age);
		double doubleAge = intAge;
		
		
		System.out.println("Your age as int: "+intAge);
		System.out.print("Your age as double: "+doubleAge);

	}

}
