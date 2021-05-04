package method;
import java.util.Arrays;

public class Main_school {
	public static void main(String[] args) {
		
	  // 리스트로 10명의 성적데이터를 받아보자.
		
		Base_school[] StudentList = {new Base_school("김진규", 100, 100), 
							  new Base_school("김서준", 58, 89), 
							  new Base_school("송사무엘", 80, 30),
							  new Base_school("김홍익", 20, 50),
							  new Base_school("이주혁", 10, 100),
							  new Base_school("김동환", 50, 100),
							  new Base_school("박성진", 100, 20),
							  new Base_school("노재원", 15, 20),
							  new Base_school("금봉연", 50, 60),
							  new Base_school("이광천", 5, 5)};
		
		
		// 출력해보자
		
		for(int i = 0; i < StudentList.length; i++) {
			StudentList[i].totalScore(); //총점 계산
			StudentList[i].evenScore(); // 평균점수 계산
			StudentList[i].printScore(); // 이름과 총점, 평균점수 출력 
			
		}
		
	
		for(int i = 0; i < StudentList.length-1; i++) {
			for(int j = i+1; j < StudentList.length; j++) {
				if(StudentList[i].totalScore > StudentList[j].totalScore) {
					Base_school temp = StudentList[i]; //Base class의 객체를 사용하고 있으니 Base 타입의 변수를 써야 한다.
					StudentList[i] = StudentList[j];
					StudentList[j] = temp;
				}
			} 
			
			
			
			// 정렬 후 성적순 출력
		} System.out.println(Arrays.toString(StudentList));
			
			
		}
	
	
	
	
	}


