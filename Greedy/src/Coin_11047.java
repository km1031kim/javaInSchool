import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Coin_11047 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/coin.txt"));

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int T = sc.nextInt();
		int count = 0;
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();

		}

		for (int i = N - 1; i >= 0; i--) {
			if (T >= arr[i]) {
				count += T / arr[i]; // 몫을 카운트로!
				T = T % arr[i]; // 나머지를 남은 돈으로!
			}
		}

		System.out.println(count);

	}

}
