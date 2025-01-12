package a01CoreJavaFundamentals;

import java.util.Scanner;

public class GCDAndLCM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = calculateGCD(a, b);
        int lcm = (a * b) / gcd; // Formula: LCM = (a * b) / GCD
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
        sc.close();
	}
	// Method to calculate GCD using the Euclidean Algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; // The final value of 'a' is the GCD
    }
}
