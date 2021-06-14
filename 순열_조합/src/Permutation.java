import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	public static void main(String[] args) {
		// 입력 N(자연수, 1이상 8이하) 이 주어졌을 때, 1부터 N까지의 순열을 오름차순으로 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// arr 필요, size 필요, branch 필요, level 필요, boolean필요

		if (N >= 1 && N <= 8) {
			int K = 1;
			String str;

			str = Integer.toString(K);
			for (int i = 1; i < N; i++) {
				str += Integer.toString(++K);

			}
//			System.out.println(str);

			char[] arr = new char[N];

			for (int i = 0; i < N; i++) {
				arr[i] = str.charAt(i);
			}
//			System.out.println(arr);
		
			int size = arr.length;
			char[] branch = new char[size];
			int level = -1;
			boolean[] visited = new boolean[size];
			
			for(int i = 0; i < size; i++) {
				visited[i] = false;
			}
			System.out.println(Arrays.toString(visited));
			
			generatePermutations(arr, size, branch, level, visited);

		} else System.out.println(-1);

	}

	static void generatePermutations(char[] arr, int size, char[] branch, int level, boolean[] visited) {
		if (level >= size - 1) {
			System.out.println(branch);
			return;
		}

		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				branch[++level] = arr[i];
				visited[i] = true;
				generatePermutations(arr, size, branch, level, visited);
				visited[i] = false;
				level--;
			}
		}
	}

}
