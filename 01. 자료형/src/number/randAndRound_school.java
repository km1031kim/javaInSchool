package number;
import java.util.Random;
import java.util.Scanner;

public class randAndRound_school {
	public static void main(String[] args) {
		System.out.println("숫자를 입력해주세요.");

		Scanner s1 = new Scanner(System.in); // scanner 고용
		int userNumber = s1.nextInt(); // 일시키기 - 숫자 받아와.

		Random r1 = new Random(); // random 고용
		int randNumber = r1.nextInt(100); //일시키기 - 랜덤 숫자 받아.

		System.out.println("사용자가 입력한 숫자 : " + userNumber + ", 랜덤 생성된 숫자 : " + randNumber);
		
		int resultNum = userNumber + randNumber;
		System.out.println("" + userNumber + " + " + randNumber + " = " + resultNum);
		
		
		
		double resultNum2 = userNumber / (double)randNumber;
		resultNum2 = Math.round(resultNum2 * 100) / (double)100 ;
		System.out.println("" + userNumber + " / " + randNumber + " = " + resultNum2);
	
		
	}

}