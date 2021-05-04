package booleaN;

public class PrimeHundred_school {
	public static void main(String[] args) {
		
		// 1 ~ 100까지의 수 number 생성
	
	for (int i = 0; i < 100; i++) {
		int number = i + 1;
		
		// 0과 1은 소수가 아니니 제외
		
		if (number < 2) {
			continue;
		}
		
		
		// number를 나누기 위한 j < number 인 수 j 생성. 
		
	boolean isPrime = true;
		for(int j = 0; j < number; j++) {
			
			// 0 과 1을 제외한, number보다 작은 수로 나눠질 시에 소수가 아님
									
			if (j < 2) {
				continue;
			}
			
			if (number % j == 0) {
				isPrime = false;
				break;
			}
			}
		
		// 소수인 값 number 출력
		if (isPrime) {
			System.out.println(number);	
			}
		}
	}

}
