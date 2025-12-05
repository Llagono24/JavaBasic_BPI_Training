/**
 * 
 */
package m1.act5;

/**
 * 
 */
public class JavaBasicActivity5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {// Start of main method
		
		int num = 0;
		System.out.println("Sum: "+loop(num)); //Print sum and call Loop method for sum
	
	}// End of main method

	public static int loop(int num) { // Start of loop method
		
		for(int i = 1; i <= 50; i++) {
			num += i;
		}
		
		return num;
	}// End of loop method

}
