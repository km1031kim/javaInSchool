package staTic;
import java.util.Arrays;
import java.util.Random;

public class static_array_school {
	
 public static void main(String[] args) {
	
	 int[] score = {0, 0, 0, 0, 0, 0, 0 ,0, 0, 0};
	
	 
	 // score에 점수를 넣어줘. //파라미터 = 스코어, score를 넘겨줘
	 insertNumber(score);
	 
	 
	 //확인
	 System.out.println(Arrays.toString(score));
	 calcScore(score);
	 //score의 총합을 구해줘
	 
 	} 
 
 
 //리턴시켜주는경우는 뭔가 실행을 했는데 결과값, 특정값에 대해서 호출한 곳, 명령한 곳에다가 되돌릴 필요가 있을떄.
 // 그 경우에는 void 값을 해당 값으로 ex. int, int[] 등으로 변경시켜야한다.  
 
 									//score가 넘겨준 배열을 s에서 사용.
 public static void insertNumber(int[] s) {
	 Random r1 = new Random();
	 for (int i = 0; i < s.length; i++) {
		 s[i] = r1.nextInt(101);
	 }
	 
 }
 
 
 public static void calcScore(int[] s) {
	 int total = 0;
	 for (int i = 0; i < s.length; i++) {
		 total = total + s[i];
	 }
	 System.out.println("총합 : " + total);
 }
 
}
