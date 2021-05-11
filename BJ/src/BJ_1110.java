import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BJ_1110 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/1110.txt"));

		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		System.out.println(userInput);

		// 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 수를 더한다..
		// 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있따.
		// 26 -> 2 + 6 = 8. 68 -> 6 + 8 = 14.

		int leftnum = 0; // 왼쪽 수
		int rightnum = 0; // 오른쪽 수
		String defalut = userInput; // 처음 받은 문자(두자리 수) 를 default에 넣는다.
		if (userInput.split("").length == 1) { // 10보다 작은 수일 경우. 
			defalut = ("" + 0 + userInput); // 0앞에 0을 더한, 숫자의 형태를 한 문자로 만들어준다. ex) "6" -> "06" 
			userInput = defalut; // 그러구나서 userInput 바꿔주기. ex) "6" -> "06" 

		} 

		int cnt = 0; // 몇 번에 걸쳐 원래의 수로 돌아오는지 cnt

		while (true) {

			String[] arr = defalut.split("");
			leftnum = Integer.parseInt(arr[0]); // 왼쪽 수 int 치환
			rightnum = Integer.parseInt(arr[1]); // 오른쪽 수 int 치환.
			if (leftnum + rightnum < 10) { // 왼쪽과 오른쪽을 더했을 때, 두 수의 합이 10보다 작은 경우.
				defalut = ("" + rightnum + (leftnum + rightnum));
				cnt++;

			} else {	 // 왼쪽과 오른쪽을 더했을 때, 두 수의 합이 10보다 큰 경우는 그냥 10 빼서 오른쪽 수만 가져온다.
				defalut = ("" + rightnum + (leftnum + rightnum - 10));
				cnt++;
			}

			if (defalut.equals(userInput)) { // 처음 수와 같아지면 break;
				break;
			}

		}

		System.out.println(cnt);
	}

}
