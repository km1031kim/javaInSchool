import java.io.FileInputStream;
import java.util.Scanner;

public class JIngyuQ1_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		sc.nextLine();
		int cnt = 0;
		for(int i = 0; i < number; i++) {
			char[] arr = sc.nextLine().toCharArray();
			
			for(int j = 0 ; j < arr.length; j++) {
				if(arr[j] == 'A') {
					cnt++;
				}
			} System.out.println(cnt);
		}
		
	
	}

}
