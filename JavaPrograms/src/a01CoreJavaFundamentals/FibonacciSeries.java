package a01CoreJavaFundamentals;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of terms for the Fibonacci series:");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.println("Fibonacci series up to " + n + " terms:");
            printFibonacci(n);
        }

        sc.close();
	}
	
	public static void printFibonacci(int n) {
        long first = 0, second = 1;

        // Print the first n terms
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");

            // Update values for the next term
            long next = first + second;
            first = second;
            second = next;
        }
    }
}
