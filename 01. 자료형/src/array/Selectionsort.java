package array;
import java.util.Arrays;
import java.util.Random;

public class Selectionsort {
	public static void main(String[] args) {
		
		// 30 랜덤 리스트 생성
		
		
	 int randList[] = new int[30];
	 
	 Random r = new Random();
	 
	 
	 for (int i = 0; i < randList.length; i++) {
		 
		 int numeber = r.nextInt(101);
		 
		 randList[i] = numeber;
		 
	 }
	 
	 System.out.println(Arrays.toString(randList));
	 int biggerNum = 0;
	 
	 
	 for (int j = 0; j < randList.length-1; j++) {
		 
		 for (int k = j+1; k < randList.length; k++) {
			 
			 if (randList[j] > randList[k]) {
				 biggerNum = randList[j];
				 randList[j] = randList[k];
				 randList[k] = biggerNum;
				 
				 
			 }
		 }
	 }
	
		System.out.println(Arrays.toString(randList));
		
	}
}
