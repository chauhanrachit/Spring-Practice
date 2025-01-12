package a01CoreJavaFundamentals;

import java.util.Scanner;

public class InputAndOutputUsingScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("int");
		int a = sc.nextInt();
		System.out.println("a:"+a);
		
		System.out.println("float");
		float b = sc.nextFloat();
		System.out.println("b:"+b);
		
		System.out.println("double");
		double c = sc.nextDouble();
		System.out.println("c:"+c);
		
		System.out.println("char");
		char d = sc.next().charAt(0);
		System.out.println("d:"+d);
		
		System.out.println("boolean");
		boolean e = sc.nextBoolean();
		System.out.println("e:"+e);
		
		System.out.println("byte");
		byte f = sc.nextByte();
		System.out.println("f:"+f);
		
		System.out.println("short");
		short g = sc.nextShort();
		System.out.println("g:"+g);
		
		System.out.println("long");
		long h = sc.nextLong();
		System.out.println("h:"+h);
		
		//to consume the newline
		/*
		 * issue arises because Scanner.nextLine() behaves differently when used after nextInt(), nextFloat(), 
		 * or other similar methods. These methods do not consume the newline character \n left in the input buffer, 
		 * causing nextLine() to read the leftover newline instead of waiting for actual input.
		 * */
		sc.nextLine();
		
		System.out.println("String");
		String i = sc.nextLine();
		System.out.println("i:"+i);
		
		sc.close();
	}

}
