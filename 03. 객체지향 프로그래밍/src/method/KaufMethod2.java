package method;
import java.util.Scanner;

public class KaufMethod2 {
	
	
	
	public double userInputWeight() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("체중을 입력해주세요(kg) : ");
		String userInputText = scanner.nextLine();
		double weight = Double.parseDouble(userInputText);
		return weight;
		
		
		
	}
	
public double userInputHeight() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("신장을 입력해주세요(m) : ");
		String userInputText2 = scanner.nextLine();
		double height = Double.parseDouble(userInputText2);
		return height;
		
		
		
	}

	public void calcKaup(double weight, double height) {
		
		
		double kaup = (double)weight / (height * height);
		
		if (kaup >= 30) {
			System.out.println("너 돼지");
		} else if (kaup >= 24) {
			System.out.println("너 약간 돼지"); 
		} else if (kaup >= 20) {
				System.out.println("정상");
		} else if (kaup > 15) {
			System.out.println("멸치");
		} else if (kaup >= 10) {
			System.out.println("영상실조");
		} else {
			System.out.println("마른멸치");
		}
		
	}
}
