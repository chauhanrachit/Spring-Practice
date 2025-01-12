package a01CoreJavaFundamentals;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		int num = sc.nextInt();
		int sum = calculateSumOfDigits(num);
		System.out.println("The sum of digits of " + num + " is: " + sum);
		sc.close();
	}
	// Method to calculate the sum of digits
    public static int calculateSumOfDigits(int num) {
        int sum = 0;
        // Handle negative numbers
        num = Math.abs(num);
        while (num > 0) {
            sum += num % 10; 
            num /= 10;
        }
        return sum;
    }
}
