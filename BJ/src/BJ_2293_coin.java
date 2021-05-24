import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2293_coin {
	static int[] column;
	static int[] row;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rowNum = Integer.parseInt(br.readLine());
		int colNum = Integer.parseInt(br.readLine());

		column = new int[colNum];
		row = new int[rowNum];
		dp = new int[colNum];
		int cnt = 1;
		for (int i = 0; i < colNum; i++) {
			column[i] = cnt;
			cnt++;
		}
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = dp[2] + dp[0];
		System.out.println(Arrays.toString(column));

			
	}

}
