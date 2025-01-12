package a01CoreJavaFundamentals;

import java.util.Scanner;

public class SwappingNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();

        swapWithThirdVariable(a,b);
        System.out.println();
        SwapWithoutThirdVariable(a,b);
        
        sc.close();
	}
	
	public static void swapWithThirdVariable(int a, int b) {
		System.out.println("Swap With Third Variable : ");
		System.out.println("Before swapping: a = " + a + ", b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping: a = " + a + ", b = " + b);
	}
	
	public static void SwapWithoutThirdVariable(int a, int b) {
		System.out.println("Swap Without Third Variable : ");
		System.out.println("Before swapping: a = " + a + ", b = " + b);
		a = a + b; // Step 1: a becomes the sum of a and b
        b = a - b; // Step 2: b becomes the original value of a
        a = a - b; // Step 3: a becomes the original value of b
        System.out.println("After swapping: a = " + a + ", b = " + b);
	}

}
