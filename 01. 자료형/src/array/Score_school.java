package array;
import java.util.Arrays;
import java.util.Scanner;import org.w3c.dom.UserDataHandler;

public class Score_school {
	public static void main(String[] args) {
		
		// 0 ~ 100 까지의 점수 5개 입력받고, 그걸 리스트로 만들기
		
		
		// 0 ~ 100 까지의 점수 5번 입력받기.
		
		Scanner s = new Scanner(System.in);
		
		int gradeList[] = new int[5];
		
		
		for (int i = 0; i < 5; i++) {
		
					
			int userInputNumber = s.nextInt();
			
			// 입력값 범위 지정
			if (userInputNumber > 100 || userInputNumber < 0) {
				System.out.println("1 ~ 100까지의 수가 아닙니다.");
				break;
				} 
			
			
			gradeList[i] = userInputNumber;
			
			
			// 입력값을 리스트로 만들기
			
			
			
			
		}
		
		System.out.println(Arrays.toString(gradeList));
	}

}
