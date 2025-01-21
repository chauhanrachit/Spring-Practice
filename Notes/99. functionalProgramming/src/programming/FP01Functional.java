package programming;

import java.util.List;

@SuppressWarnings("unused")
public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "kubernetes");
//		printAllNumbersInListFunctional(numbers);
//		printEvenNumbersInListFunctional(numbers);
//		printOddNumbersInListFunctional(numbers);
//		printSquaresOfNumbers(numbers);
//		printCubesOfEvenNumbers(numbers);
//		printCubesOfOddNumbers(numbers);
//		printAllCourses(courses);
		printCoursesStartingWithS(courses);
//		printCoursesWithAtleastFourLetters(courses);
//		printCoursesContainingSpring(courses);
//		printNumberOfCharactersInCourses(courses);

	}

	private static void printNumberOfCharactersInCourses(List<String> courses) {
		courses.stream()
			.map(course ->course +" : "+ course.length())	
			.forEach(System.out::println);
	}

	private static void printCubesOfOddNumbers(List<Integer> numbers) {
		numbers.stream()
			.filter(number -> number %2 !=0)
			.map(number -> number*number*number)	
			.forEach(System.out::println);
	}

	private static void printCubesOfEvenNumbers(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number %2 ==0)
		.map(number -> number*number*number)	
		.forEach(System.out::println);
	}

	private static void printSquaresOfNumbers(List<Integer> numbers) {
		numbers.stream()
			.map(number -> number*number)	
			//this expression is called a mapping expression, where we are mapping a number to number into number	
			.forEach(System.out::println);
	}

	private static void printCoursesContainingSpring(List<String> courses) {
		courses.stream()
			.filter(course -> course.contains("Spring"))
			.forEach(System.out::println);
	}

	private static void printCoursesWithAtleastFourLetters(List<String> courses) {
		courses.stream()
			.filter(course -> course.length()>3)
			.forEach(System.out::println);

	}

	private static void printCoursesStartingWithS(List<String> courses) {
		courses.stream()
			.filter(course -> course.startsWith("S"))		//(course.charAt(0)=='S')||(course.charAt(0)=='s')
			.forEach(System.out::println);
	}

	private static void printAllCourses(List<String> courses) {
		courses.stream()
			.forEach(System.out::println);
	}

	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
			.filter(number -> number%2!=0)
			.forEach(System.out::println);
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream().forEach(System.out::println);
	}
	
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		
		numbers.stream()
		.filter(number->number%2==0) //Lambda Expression
		//Take a variable(number) then check (number%2==0) 
		.forEach(System.out::println);

//		numbers.stream()
//			.filter(FP01Functional::isEven) //Filter - Only Allow Even Numbers
//			.forEach(System.out::println);	//Method Reference
		
		//Important thing in Method reference is that we are not really calling it, 
		//we are just declaring that this is the method to be called on each of the element, 
		//and if it returns true back, only then go to the next line of code
	}
	
	
	
//	private static boolean isEven(int number) {
//		return number%2==0;
//	}
	
//	private static void printAllNumbersInListFunctional_01(List<Integer> numbers) {
//
//		// What to do?
//		// 1. Convert the list of numbers to stream of numbers
//		// 2. perform operation for each element through forEach() method
//		// 3.Using Method Reference to call a print function on each element
//
//		numbers.stream().forEach(FP01Functional::print);// method reference -> (ClassName::StaticFunctionName)
//
//		// How To loop the numbers?
//		// for(int number: numbers) {
//		// System.out.println(number);
//		// }
//	}
	
//	private static void print(int number) {
//		System.out.println(number);
//	}
}
