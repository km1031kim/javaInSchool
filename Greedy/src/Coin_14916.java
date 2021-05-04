import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Coin_14916 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/coin2.txt"));

		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int count = 0;
		int cnt = -1;
		
	
		System.out.println(N);
		// 2 나 5 로 나눠서 나머지가 없는 경우 그 몫을 count 하고, 나머지가 홀수인 경우에는 몫을 -1.

		// 예) 13을 5나 2로 거슬러줄라고 한다면
		// 13을 5*2로 나누면 나머지가 3 이기에(홀수) 2로 거슬러 줄 수 없다.
		// 이럴때는 13/5 의 몫을 -1을 하고, 그 나머지를 2로 나눈다.

		
		
		for (int i = 0; i < 100; i++) {
			if(N/5 == 0) {
				count = count + N/5;
				break;
			}else if ((N - (2 * i)) % 5 == 0) {
				N = N - (2 * i);
				count = i + N/5;
				break;		
			} else System.out.println(cnt);

		} System.out.println(count);
	
	}

}
