package ifGrammar;
import java.util.Scanner;

public class PrimeNumber_school_two {
	public static void main(String[] args) {
		System.out.println("숫자(정수)를 입력해주세요.");
		
		Scanner s1 = new Scanner(System.in);
		int number = s1.nextInt();
		
		System.out.println("입력받은 숫자는 " + number + "입니다.");
		
		boolean isPrime = true;
		for (int i = 0; i < number; i++) {
			if (i < 2) {
				continue;
			}
			if (number % i == 0) {
				isPrime = false;
			}
		}
		
		if (isPrime) {
			System.out.println("소수입니다.");
			
		} else System.out.println("소수가 아닙니다.");
	}
}

