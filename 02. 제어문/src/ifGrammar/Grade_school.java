package ifGrammar;
import java.util.Random;
import java.util.Scanner;

public class Grade_school {
	public static void main(String[] args) {

		System.out.println("당신의 이름을 입력하세요.");
		Scanner s = new Scanner(System.in);

		while (true) {
			String name = s.next();

			Random r = new Random();
			int grade = r.nextInt(101);

			if (grade >= 90) {
				System.out.println(name + "님의 학점은 A 입니다. ");
			} else if (grade >= 80 && grade < 90) {
				System.out.println(name + "님의 학점은 B 입니다. ");
			} else if (grade >= 70 && grade < 80) {
				System.out.println(name + "님의 학점은 C 입니다. ");
			} else if (grade >= 60 && grade < 70) {
				System.out.println(name + "님의 학점은 D 입니다. ");
			} else if (grade >= 50 && grade < 60) {
				System.out.println(name + "님의 학점은 E 입니다. ");
			} else if (grade < 50) {
				System.out.println("낙제입니다. 재수강!");
			}

			
		
		}
	}

}
