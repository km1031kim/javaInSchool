import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int sizeX = sc.nextInt();
		int sizeY = sc.nextInt();

		// 입력값 기준 1,1 은 실제 데이터에선 0,0 이므로 배열을 1 크게 만들어서 계산에 편하게 한다.

		int arr[][] = new int[sizeX + 1][sizeY + 1];

	
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = r.nextInt(15+1); 
			}
		}
		

	
		int gameCount = sc.nextInt();

		for (int i = 0; i < gameCount; i++) {
			int targetX = sc.nextInt();
			int targetY = sc.nextInt();
			int sumX = 0;
			int sumY = 0;
		
				// 가로부터 더해보자  
				for(int k = 0; k < arr[2].length; k++) {
					sumX += arr[targetY][k];
					
				}
			
				// 세로 더해보자
				for (int k = 0; k < arr.length; k++) {
					sumY += arr[k][targetY];
				}

			
			System.out.println("" + sumY + " " + sumX);
		}

	}
}
