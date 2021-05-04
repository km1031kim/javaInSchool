import java.util.Arrays;
import java.util.Scanner;

public class YoungSunQ4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");

		int size = Integer.parseInt(arr[0]);
		int cnt = Integer.parseInt(arr[1]);
		int agn = Integer.parseInt(arr[2]);

		String[] line = sc.nextLine().split(" ");

		int[] number = new int[size];
		for (int i = 0; i < size; i++) {
			number[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(number); // 1 2 3 4 5

		int first = number[size - 1];
		int second = number[size - 2];
		int sum = 0;
		int tempk = agn;

		for (int i = 0; i < cnt; i++) {
			if (tempk == 0) {
				sum = sum + second;
				tempk = agn;

			} else {
				sum = sum + first;
				tempk--;
			}
		}
		System.out.println(sum);
	}
}
