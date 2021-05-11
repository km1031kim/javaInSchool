import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_2573 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/2573.txt"));
		Scanner sc = new Scanner(System.in);

		int height = sc.nextInt();
		int width = sc.nextInt();
		int[][] arr = new int[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		int cnt = 0; // 빙산이 분리되는 최초의 시간(년)
		int chunk = 1; // 연결된 빙산을 세보자. 처음엔 한덩어리.

		// 1년마다 상하좌우 0의 개수만큼 높이가 감소한다. 높이는 음수가 되지 않는다.
		// 연결된 빙산을 정의하는게 중요할듯.

		// 일단 상하좌우 0의 개수만큼 높이가 줄게 해보자.

		
		
		while (true) {
			int[][] temp = new int[height][width];
			
			
			
			int firstNumber = 0;
			int firstcnt = 0;
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] != 0) {
						firstcnt++;
						firstNumber = arr[i][j];
						
					}
					
				}
			}
			
			int secondcnt = 0;
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == firstNumber) {
						secondcnt++;
						
					}
				}
			}
			
			if(firstcnt == secondcnt) {
				System.out.println(0);
				break;
			}
			

			for (int j = 0; j < arr.length; j++) {

				for (int k = 0; k < arr[j].length; k++) {
					if (arr[j][k] != 0) { // 높이가 있는 빙산인 경우
						int sea = 0; // 해당 수 상하좌우에 있는 0(바다)의 개수
						if (arr[j - 1][k] == 0) { // 위가 바다인가?
							sea++;
						}
						if (arr[j][k + 1] == 0) { // 오른쪽이 바다인가?
							sea++;
						}
						if (arr[j + 1][k] == 0) { // 아래가 바다인가?
							sea++;
						}
						if (arr[j][k - 1] == 0) { // 왼쪽이 바다인가?
							sea++;
						}

						if (sea != 0) {
							temp[j][k] = sea;

						}

					}

				}

			}

			// 빙산을 한번에 녹이자.
			int sameNumber = 0;
			int notZeroCnt = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr[j].length; k++) {
					if (arr[j][k] != 0) {
						if (temp[j][k] != 0) {
							arr[j][k] -= temp[j][k];
							if (arr[j][k] < 0) {
								arr[j][k] = 0;
							} else
								sameNumber = arr[j][k];
								notZeroCnt++;
						}

					}
				}
			}

			// 모둔 빙산의 높이가 같을 때. 빙산이 쪼개지지 않고 다 녹아버린다 - > 0출력
			
			int eachNumber = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr[j].length; k++) {
					if (arr[j][k] != 0) {
						 if(arr[j][k] == sameNumber) {
							 eachNumber++;
						 }
						
						
					}

				}
			}
			if(eachNumber == notZeroCnt) {
				System.out.println(0);
				break;
			}

			cnt++; // 빙산이 녹고 1년 지남.

			// 몇 덩어리인지 확인해보자.
			for (int j = 0; j < arr.length; j++) {

				for (int k = 0; k < arr[j].length; k++) {
					if (arr[j][k] != 0) { // 높이가 있는 빙산인 경우

						if (arr[j - 1][k] == 0 && arr[j][k + 1] == 0 && arr[j + 1][k] == 0 && arr[j][k - 1] == 0) {
							// 상하좌우가 바다인 경우엔 이 놈 혼자 한 덩어리가 된다. chunk 추가
							chunk++;
						}
					}
				}
			}

			if (chunk >= 2) { // 빙산이 두개로 분리되면.
				System.out.println(cnt);
				break;
			}

		}

	}

}
