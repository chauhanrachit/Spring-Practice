package a01CoreJavaFundamentals;

public class ChangeValueOfArray {

	public static void main(String[] args) {
		int[] a = {10};
		System.out.println("1:"+a[0]);
		change(a);
		System.out.println("4:"+a[0]);
		changed(a);
		System.out.println("7:"+a[0]);
		
		String str = new String ();
		str="Hello";
		System.out.println("1:"+str);
		change(str);
		System.out.println("4:"+str);

	}
	
	public static void change (String str) {
		System.out.println("2:"+str);
		str="Bye";
		System.out.println("3:"+str);
	}
	
	private static int[] changed(int[] a) {
		System.out.println("5:"+a[0]);
		a[0]=40;
		System.out.println("6:"+a[0]);
		return a ;
	}

	public static void change (int[] a) {
		System.out.println("2:"+a[0]);
		a[0]=20;
		System.out.println("3:"+a[0]);
	}
	
	/*
	 * 1:10
	 * 2:10
	 * 3:20
	 * 4:20
	 * 5:20
	 * 6:40
	 * 7:40
	 * 1:Hello
	 * 2:Hello
	 * 3:Bye
	 * 4:Hello
		*/
}
