package a01CoreJavaFundamentals;

import java.util.Scanner;

public class PrimeNumberCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int num = sc.nextInt();

        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }

        sc.close();	}
	
	public static boolean isPrime(int n) {
        // Handle special cases
        if (n <= 1) 
        	return false; // 0 and 1 are not prime
        if (n <= 3) 
        	return true;  // 2 and 3 are prime

        // Eliminate even numbers and multiples of 3
        if (n % 2 == 0 || n % 3 == 0) 
        	return false;

        // Check divisors from 5 to sqrt(n)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) 
            	return false;
        }

        return true;
    }
}
