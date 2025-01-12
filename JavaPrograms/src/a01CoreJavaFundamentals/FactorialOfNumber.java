package a01CoreJavaFundamentals;

import java.util.Scanner;

public class FactorialOfNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		long num = sc.nextLong();
		if (num < 0) 
			System.out.println("Factorial is not defined for negative numbers.");
		else {
			System.out.println("Factorial of " + num + ", through      loop is: " + FatorialByLoop(num));
			System.out.println("Factorial of " + num + ", through recursion is: " + FatorialByLoop(num));
		}
		sc.close();
	}

	public static long FatorialByRecursion(long num) {
		if(num<=1)
			return 1;
		return num * (num-1);
	}
	public static long FatorialByLoop(long num) {
		long factorial = 1;
		for (int i = 1; i <= num; i++)
			factorial *= i;
		return factorial;
	}
}
