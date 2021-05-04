package staTic;

import java.util.Random;

public class static_sum_school {
	public static void testMethod() {
		Random r1 = new Random();
		
		int number1 = r1.nextInt(100);
		int number2 = r1.nextInt(100);
		
		int resultNumber = number1 + number2;
		
		System.out.println("" + number1 + " + " + number2 + " = " + resultNumber);
		System.out.println(resultNumber);
	
	}
	
	
	public static void testMethod2() {
		Random r2 = new Random();
		
		int number1 = r2.nextInt(100);
		int number2 = r2.nextInt(100);
		
		int resultNumber = number1 - number2;
		System.out.println("" + number1 + " - " + number2 +  " = "  + resultNumber);
	}
	
	
		public static void main(String[] args) {
		 testMethod();
		 testMethod();
		 testMethod2();
		}
	}
	