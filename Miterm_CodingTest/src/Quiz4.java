import java.util.Arrays;
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String numberList = sc.nextLine();
		String[] arr = numberList.split(" ");
		
		int numberLength = Integer.parseInt(arr[0]);
		int pluscnt = Integer.parseInt(arr[1]);
		int limit = Integer.parseInt(arr[2]);
		

		
		String[] Stringarr = sc.nextLine().split(" ");
		int[] numberArr = new int [numberLength];
		
		for(int i = 0; i < numberArr.length; i++) {
			numberArr[i] = Integer.parseInt(Stringarr[i]);
		}
	
		Arrays.sort(numberArr);
		
		int firstNumber = numberArr[numberLength - 1];
		int secondNumber = numberArr[numberLength -2];
		int temp = 0;
		int sum = 0;
		for(int i = 0; i < pluscnt; i++) {
			if(limit == temp) {
				sum += secondNumber;
				temp = 0;
			}
			
			else {
				sum += firstNumber;
				temp++;
			}
		} System.out.println(sum);
	}

}
