package a01CoreJavaFundamentals;

import java.util.Scanner;

public class PalindromeCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string:");
		String input = sc.nextLine();

		if (isPalindromeString(input))
			System.out.println("\"" + input + "\" is a palindrome.");
		else
			System.out.println("\"" + input + "\" is not a palindrome.");
		
		System.out.println("Enter a number:");
        long num = sc.nextLong();

        if (isPalindromeNumber(num))
            System.out.println(num + " is a palindrome.");
        else
            System.out.println(num + " is not a palindrome.");
		
		sc.close();
	}

	// Method to check if a string is a palindrome
	public static boolean isPalindromeString(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right))
				return false;
			left++;
			right--;
		}

		return true;
	}

	// Method to check if a number is a palindrome
	public static boolean isPalindromeNumber(long num) {
		long original = num;
		long reversed = 0;

		while (num > 0) {
			long digit = num % 10;
			reversed = reversed * 10 + digit;
			num /= 10;
		}

		return original == reversed;
	}
}
