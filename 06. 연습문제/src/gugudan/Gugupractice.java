package gugudan;
import java.util.Scanner;

public class Gugupractice {public static void main(String[] args) {
	System.out.println("2 ~ 9까지의 수를 입력하세요");
	Scanner s = new Scanner(System.in);
	
	while(true) {
		int userInputNumber = s.nextInt();
		String inValidNumber = "2 ~ 9 사이의 값이 아닙니다.";
		
	  if (userInputNumber > 9 || userInputNumber <= 1) {System.out.println(inValidNumber);}
			else {
				for(int i=1;i<10;i++) System.out.println(userInputNumber + " * " + i + " = " + userInputNumber * i);
					break;                                                                           
			}
		}
 	}
}
