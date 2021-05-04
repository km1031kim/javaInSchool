package ifGrammar;

public class Eventotal_school {
	public static void main(String[] args) {
		
		// 1 ~ 100 까지 수의 합
		// 홀수의 합
		// 짝수의 합 
		
		// 값 지정
		int toTal = 0;
		int evenTotal = 0;
		int oddTotal = 0;
		
		// 1 ~ 100 까지 더하는 반복문 생성
		
		for (int i = 0; i < 100; i++) {
			int a = i + 1;
			
			// 1 ~100 까지 총합 구하기
			toTal = toTal + a;
			
			// 짝수끼리의 합 구하기
			if (a % 2 == 0) {
				evenTotal = evenTotal + a;
			} else	oddTotal = oddTotal + a;
		}
		System.out.println(oddTotal);
		System.out.println(evenTotal);
		System.out.println(toTal);
	}

}
