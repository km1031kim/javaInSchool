import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int gameCount = sc.nextInt();

		for (int i = 0; i < gameCount; i++) {

			// 5을 넣엇으니 서로 다른 배열이 만들어 져야 한다.
			// 1~10까지의 수로 랜덤으로 넣어서 배열 생성해보자.

			// 랜덤으로 길이 설정.
			int[] arr = new int[r.nextInt(10) + 1];

			for (int j = 0; j < arr.length; j++) {
				arr[j] = r.nextInt(10) + 1;
			}  

			// 배열 값 생성했으니 중복값 제거 한 후 정렬해보자.

			int[] cnt = new int[11];

			for (int j = 0; j < arr.length; j++) {
				cnt[arr[j]]++;

			}
			for (int j = 0; j < cnt.length; j++) {
				if (cnt[j] > 0) {
					System.out.print(j + " ");
				}
			}
			System.out.println();

		}

	}

}
