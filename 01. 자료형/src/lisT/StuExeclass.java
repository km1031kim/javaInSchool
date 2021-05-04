package lisT;

import java.util.ArrayList;

public class StuExeclass {
	public static void main(String[] args) {
		// 객체 만들어서 바로 초기값 잡아주거니
		Student[] s1 = {new Student("홍길동", 500), new Student("둘리", 300), new Student("또치", 200)};
		
		// 배열 만들고 따로따로 객체 생성
		Student[] s2 = new Student[3];
		s2[0] = new Student("도우너",300);
		s2[1] = new Student("마이콜",100);
		s2[2] = new Student("희동이",500);
		
		
		// 자바에서는 그냥 어레이리스트 써라
		// Generic이라는 문법 추가
		// <Student> 타입이다.
		ArrayList<Student> s3 = new ArrayList<Student>();
		s3.add(new Student("김진규", 900));
		s3.add(new Student("김박최", 300));
		
		s3.get(0).name = "김굼"; // s3.get(0) == s2[0] 같은거임.
		s3.get(1).middleScore = 500;
		
		// 출력해보자
		for(int i = 0; i < s3.size(); i++) {
		 System.out.println(s3.get(i).name + "의 중간고사 점수 : " + s3.get(i).middleScore);
		}
		
	}

}
