package array;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class RandSum_school {
	public static void main(String[] args) {
		// 1 ~ 100 까지의 점수 5번 입력받고, 리스트로 만들자.
		
		
		// 1 ~ 100 까지의 점수 5번 입력받기.
		
		Scanner s = new Scanner(System.in);
		
		int gradesList [] = new int[5];
		
		for (int i = 0; i < 5; i++) {
			
			int userGrades = s.nextInt();
			
			// 범위 밖의 수일경우
			if (userGrades > 100 || userGrades < 0) {
				System.out.println("범위 내의 수가 아닙니다.");
				break;
				
			}
			
			// 입력값 리스트로 넣기.
			gradesList[i] = userGrades;
		
		
		}
		
			// 리스트 출력
			System.out.println("당신의 점수 = " + Arrays.toString(gradesList));
		
	}

}
