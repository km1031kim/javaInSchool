package array;
import java.util.Scanner;

public class Exe_school {
	public static void main(String[] args) {
		Class_school[] Student = new Class_school[3];
		Scanner s = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {
			System.out.println("이름을 입력해주세요");
			String name = s.nextLine();
			
			System.out.println("국어 점수를 입력해주세요");
			String inputString = s.nextLine();
			int korScore = Integer.parseInt(inputString);
			
			System.out.println("영어 점수를 입력해주세요");
			String inputString1 = s.nextLine();
			int engScore = Integer.parseInt(inputString1);
			
			System.out.println("수학 점수를 입력해주세요");
			String inputString2 = s.nextLine();
			int mathScore = Integer.parseInt(inputString2);
			
			
			Student[i] = new Class_school(name, korScore, engScore, mathScore);
			
		}
		
		int totalKorScore = 0;
		int totalEngScore = 0;
		int totalMathScore = 0;
		for ( int i = 0; i < 3; i++) {
			totalKorScore = totalKorScore + Student[i].korScore;
			totalEngScore = totalEngScore + Student[i].engScore;
			totalMathScore = totalMathScore + Student[i].mathScore;
			
		}
		
		System.out.println("국어 총합 : " + totalKorScore);
	}

}
