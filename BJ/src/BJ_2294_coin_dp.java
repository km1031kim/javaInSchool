import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2294_coin_dp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arr[] = { 0, 1, 5, 12 };

		int C = Integer.parseInt(br.readLine());
		int[] coins = new int[C + 1]; // 동전의 종류

		int[] numbers = new int[Integer.parseInt(br.readLine()) + 1]; // 1~15까지
		int[] dp = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {

			numbers[i] = i;
		}

		dp[0] = 0; // 아무것도 안 내면 한가지
	
		//

		for (int i = 0; i < coins.length; i++) {
			coins[i] = arr[i];
		}

		// 해당 금액을 동전의 가격으로 나눈 몫 + 나머지가 작은 경우로 dp를 설정한다..
		for(int i = 1; i < numbers.length; i++) {
			dp[i] = i;
		}
		

		for (int i = 1; i <coins.length; i++) {
			for (int j = 1; j < numbers.length; j++) {
			
				if (numbers[j] / coins[i] >= 1) {
					dp[j] = Math.min(dp[j], (numbers[j] / coins[i]) + (numbers[j] % coins[i]));
				}
			
			}
		}

		System.out.println(Arrays.toString(coins));
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(dp));

	}

}
