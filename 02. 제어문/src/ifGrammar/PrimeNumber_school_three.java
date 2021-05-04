package ifGrammar;
import java.util.Scanner;

public class PrimeNumber_school_three { 
	public static void main(String[] args) {
		
		Scanner s1 = new Scanner(System.in);
		int number = s1.nextInt();
		
		System.out.println("입력받은 숫자는 " + number + " 입니다.");
	
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
			System.out.println("소수입니다");
		}
		
		
}

}



/// if (안의 값도 true or false다. ture면 실행. false면 실행 x) { }

// if(prime) 이 참이면 { } 가 실행 아니면 실행 x 