package ifGrammar;
import java.util.Scanner;

public class PrimeNumber_school { 
	public static void main(String[] args) {
		
		System.out.println("숫자를 입력하시와요");
		
		Scanner s1 = new Scanner(System.in);
		int number = s1.nextInt();
		
	
		boolean isPrime = (true); //이즈프라임 참
		for (int i=0; i<number; i++) {
			if (i<2) {
				continue;
			}
			if ( number % i == 0) {
				isPrime = (false);
			}
		}
		
		if (isPrime) {System.out.println("소수입니다");
		}
}
}


