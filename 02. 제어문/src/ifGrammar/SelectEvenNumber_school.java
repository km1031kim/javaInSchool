package ifGrammar;

public class SelectEvenNumber_school {
	public static void main(String[] args) {
		
		// 1 ~ 100 까지 수 중 짝수만 뽑기

		// 1 ~ 100 까지의 배열
		
		for (int i = 0; i < 100; i++) {
			int a = i +1 ;
			
			//짝수만 뽑기
			
			if ( a % 2 == 0) {
				System.out.println(a);
			}
			
		}
		
	}

}
