package step4;
import java.util.Arrays;
import java.util.Random;

public class ExecClass {
	public static void main(String[] args) {
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
		Student[] class2 = {
				new Student("이"),
				new Student("김"),
				new Student("또치"),	
				new Student("도우너"),	
				new Student("강감찬"),	
				new Student("이순신"),	
				new Student("이성계"),	
				new Student("박찬호"),	
				new Student("박세리"),	
				new Student("김연아")	
			};
		Student[] class3 = {
				new Student("박"),
				new Student("김"),
				new Student("또치"),	
				new Student("도우너"),	
				new Student("강감찬"),	
				new Student("이순신"),	
				new Student("이성계"),	
				new Student("박찬호"),	
				new Student("박세리"),	
				new Student("김연아")	
			};
		CC[] cc = {new CC("1반", class1), new CC("2반", class2), new CC("3반", class3)};
		
		for (int i = 0; i < cc.length; i++) {
			cc[i].initScore();
			cc[i].calcScore();
			cc[i].calcTotal();
			cc[i].sortStudent();
			cc[i].rankSetting();
			cc[i].printData();
		}
	}
}
