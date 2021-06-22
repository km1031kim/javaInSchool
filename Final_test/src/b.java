import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class b {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(",");
		int D = Integer.parseInt(arr[0]);

		String[] numbers = new String[arr.length - 1];
		int[] numberInt = new int[numbers.length];

		System.arraycopy(arr, 1, numbers, 0, numbers.length);

		//System.out.println(D);
	//	System.out.println(Arrays.toString(numbers));

		for (int i = 0; i < numbers.length; i++) {
			numberInt[i] = Integer.parseInt(numbers[i]);
		}

		ArrayList<Integer> answer = new ArrayList<Integer>();

		// arrInt에서 D로 나눴을 때 나머지가 0인것만 answer에 추가

		for (int i = 0; i < numberInt.length; i++) {
			if (numberInt[i] % D == 0) {
				answer.add(numberInt[i]);
			}

		}

		Collections.sort(answer);

		int[] finalAnswer = new int[answer.size()];

		for (int i = 0; i < answer.size(); i++) {
			finalAnswer[i] = answer.get(i);

		}

		if (finalAnswer.length == 0 || finalAnswer==null) {
			System.out.println(-1);
		} else {
			System.out.println(Arrays.toString(finalAnswer));
		}

	}

}
