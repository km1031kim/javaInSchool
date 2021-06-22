import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arrStr1 = br.readLine().split(" ");
		String[] arrStr2 = br.readLine().split(" ");

	//	System.out.println(Arrays.toString(arrStr1));
	//	System.out.println(Arrays.toString(arrStr2));

		int[] arrInt1 = new int[arrStr1.length];
		int[] arrInt2 = new int[arrStr2.length];

		for (int i = 0; i < arrInt1.length; i++) {
			arrInt1[i] = Integer.parseInt(arrStr1[i]);
			arrInt2[i] = Integer.parseInt(arrStr2[i]);
		}

		Arrays.sort(arrInt1);
		Arrays.sort(arrInt2);

//		System.out.println(Arrays.toString(arrInt1));

		boolean isSame = true;

		for (int i = 0; i < arrInt1.length; i++) {
			if (arrInt1[i] != arrInt2[i]) {
				isSame = false;
				break;
			}
		}

		if (isSame == true) {
			System.out.println("T");
		} else {
			System.out.println("F");
		}

	}

}
