package stringbuffer;
import java.util.Scanner;

public class Exec2 {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자를입력");
		
		
		String inputString = scanner.nextLine();
		
		StringBuffer c = new StringBuffer(inputString);
		c.reverse();
		
		String d = c.toString();  // toString = 문자열로 만든다.
		System.out.println(d);
		String e = new String(c);
		System.out.println(e);
	}

}
