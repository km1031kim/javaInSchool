package step1;

import java.util.Arrays;
import java.util.Random;

public class ExecClass {
	public static void main(String[] args) {
//		Student s1 = new Student();
//		
//		s1.name = "홍길동";
//		s1.middleScore = 900;
//		s1.finalScore = 950;
//		
//		Student s2 = new Student("둘리");
//		Student s3 = new Student("또치", 500, 400);
		
		Student[] class1 = {
			new Student("홍길동"),	
			new Student("둘리"),	
			new Student("또치"),	
			new Student("도우너"),	
			new Student("강감찬"),	
			new Student("이순신"),	
			new Student("이성계"),	
			new Student("박찬호"),	
			new Student("박세리"),	
			new Student("김연아")	
		};
		Random random = new Random();
		for (int i = 0; i < class1.length; i++) {
			class1[i].middleScore = random.nextInt(1001);
			class1[i].finalScore = random.nextInt(1001);
		}
		System.out.println(Arrays.toString(class1));
	}
}
