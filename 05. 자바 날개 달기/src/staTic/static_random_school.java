package staTic;

import java.util.Random;

public class static_random_school {
	// return 값 있을때 성질(int) 지정.
	public static int testMethod(int n1, int n2) {
	
		int resultNumber = n1 + n2;
		
		System.out.println("" + n1 + " + " + n2 + " = " + resultNumber);
		
		return resultNumber; //testMethod 값으로 return
	}
	
	// return값 없을때 void
	public static void testMethod2(int number1, int number2) {
		
		
		int resultNumber = number1 - number2;
		System.out.println("" + number1 + " - " + number2 +  " = "  + resultNumber);
	}
	
	
		public static void main(String[] args) {
			
			Random r1 = new Random();
			
			int number1 = r1.nextInt(100);
			int number2 = r1.nextInt(100);
			
			// 첫번째 값이 n1에, 두번째 값이 n2에 들어가게 된다.
		 
		int result = testMethod(number1, number2);
			
		
		 testMethod2(number1, number2);
		}
	}