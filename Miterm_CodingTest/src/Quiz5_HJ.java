import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz5_HJ {
	public static void main(String[] args) throws IOException {
		// 최댓값을 구하고 최솟값을 갱신하자.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int people = Integer.parseInt(br.readLine());

		// 100명일 때 최대로 낭비하는 경우는 45*3.
		int bus45cnt = (people / 45) + 1;
		int bus25cnt = (people / 25) + 1;

		int minPrice = 45 * bus45cnt;

		// 결과값을 담을 변수 bus45, bus25

		int bus45 = 0;
		int bus25 = 0;
		int sum = 0;
		// 1을 더했으니 작거나 같은 범위로 가야한다.

		for (int i = 0; i <= bus45cnt; i++) {
			for (int j = 0; j <= bus25cnt; j++) {
				sum = 45 * i + 25 * j;
				if (sum >= people && sum <= minPrice) {
					minPrice = sum;
					bus45 = i;
					bus25 = j;
				}

			}
		}
		System.out.println("" + bus45 + " " + bus25);

	}

}
