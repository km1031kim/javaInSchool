import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String t = sc.nextLine();

		int T = Integer.parseInt(t);
		int cnt = 0;
		for (int i = 0; i < T; i++) {
			char[] arr = sc.nextLine().toCharArray();
			
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == 'A') {
					cnt++;
				}
			}
			System.out.println(cnt);
		}

	}

}
