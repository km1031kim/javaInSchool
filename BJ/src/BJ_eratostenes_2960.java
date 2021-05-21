import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_eratostenes_2960 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/2960.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println(isPri(2));
		isPri(6);
	}

	
	public static boolean isPri(int a) {
		int cnt = 0;

		for (int i = 1; i <= a; i++) {
			if (a % i == 0) {
				System.out.println(a);
				cnt++;
			}
		}
		
		if (cnt == 2) {
			return true;
		}

		else {
			return false;
		}

	}

}
