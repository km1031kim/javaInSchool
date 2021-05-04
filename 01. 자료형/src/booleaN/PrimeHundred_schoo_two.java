package booleaN;
import java.util.Random;

public class PrimeHundred_schoo_two {
	public static void main(String[] args) {
		
		// 1~100까지의 수 중 소수만 뽑자
		
		
	
	// 100번 반복문 생성
	for(int i = 0; i < 100; i++) {
			
		// 100 이하의 소수를 구하기 위한 1~100까지의 값 number 생성.	
			int number = i + 1;
		// 0과 1 제외	
			if (number < 2) {
				continue;
			} 
			
		// 소수 판단 로직
		boolean isPrime = true;
		// number보다 작은 수 j로 반복해서 나누기
			for(int j = 0; j < number; j++) {
		// 0과 1 제외		
				if (j < 2) {
					continue;
				}
				
		// number를 j로 나눴을때 나머지가 0이 된다. = 소수가 아니다
				if (number % j == 0) {
					isPrime = false;
					break;
				}
				
				
			}
			
		// isPrime = true 일 때 값 출력
			if (isPrime) {
				System.out.println(number);
			}
		}
	}
}

