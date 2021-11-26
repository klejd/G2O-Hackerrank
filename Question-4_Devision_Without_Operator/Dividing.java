package newProj;

import java.util.Scanner;

public class Dividing {

	public static void main(String[] args) {
		// Division without the division sign
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the divident: ");
		int divident = input.nextInt();
		System.out.print("Enter the divisor: ");
		int divisor = input.nextInt();
		System.out.println("The quotient is: " + quotient(divident, divisor));
		quotNRem(divident, divisor);
	}
	
//	returns quotient only
	public static int quotient(int divident, int divisor) {
		int n = 0;
		// divisor should be greater than 0 and should be equal to divident 
		// or greater to be able to subtract and get a positive number
		while(divident >= divisor && divident != 0) {
			divident = divident - divisor;
			n++;
		}
		// number of times divisor can be subtracted from divident
		return n;
	}
	
// 	returns quotient and remainder
	public static void quotNRem(int divident, int divisor) {
		int n = 0;
		// divisor should be greater than 0 and should be equal to divident 
		// or greater to be able to subtract and get a positive number
		while(divident >= divisor && divident != 0) {
			divident = divident - divisor;
			n++;
		}
		// number of times divisor can be subtracted from divident
		System.out.println("Quotient is: " + n + "\nRemainder is: " + divident);
		
	}
}
