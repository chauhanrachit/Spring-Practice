package a01CoreJavaFundamentals;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Using StringBuilder to reverse the string
        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println("Reversed string: " + reversed);
		
		sc.close();
	}

}
