package ifGrammar;
import java.util.Random;
import java.util.Scanner;

// 가위바위보
public class RSPgame_school { 
	public static void main(String[] args) {
		
		System.out.println("가위, 바위, 보 중 하나를 입력하세요");
		System.out.println( "가위 = 1 바위 = 2 보 = 3");
		Scanner s = new Scanner(System.in);
		
		int userChoice = s.nextInt();
		System.out.println(userChoice);
		
		Random r = new Random();
		int comChoice = r.nextInt(2)+1;
		System.out.println("컴퓨터의 선택 = " + comChoice);
		
				
		if (userChoice == comChoice) {
			System.out.println("비겼습니다");
			} else if (userChoice==1 && comChoice==3) {
				System.out.println("당신이 이겼습니다");} 
			else if (userChoice==1 && comChoice==2) {
				System.out.println("당신이 졌습니다");} 
			else if (userChoice==2 && comChoice==1) {
				System.out.println("당신이 이겼습니다");} 
			else if (userChoice==2 && comChoice==3) {
				System.out.println("당신이 졌습니다");} 
			else if (userChoice==3 && comChoice==2) {
				System.out.println("당신이 이겼습니다");} 
			else if (userChoice==3 && comChoice==1) {
				System.out.println("졌습니다");} 
		
		
		
		
		
	
}

}
