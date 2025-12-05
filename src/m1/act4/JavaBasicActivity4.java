/**
 * 
 */
package m1.act4;
import java.util.Scanner;
/**
 * 
 */
public class JavaBasicActivity4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your age: ");
		int age = input.nextInt();
		input.close();
		if(age < 18) {
			System.out.println("Minor");
		}else if(age >= 18 && age <= 59) {
			System.out.println("Adult");
		}else if(age >= 60) {
			System.out.println("Senior");
		}
	}

}
