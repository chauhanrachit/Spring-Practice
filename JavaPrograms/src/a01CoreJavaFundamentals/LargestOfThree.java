package a01CoreJavaFundamentals;

import java.util.Scanner;

public class LargestOfThree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Find the largest number
        System.out.println("The largest number is: " + ((a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c)));
        sc.close();
	}

}
