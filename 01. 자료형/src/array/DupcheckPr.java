package array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DupcheckPr {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("D://inputDC.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		// T는 횟수
		int T = sc.nextInt();
		int[] arr;
		int[] NonDu;
		
		
		// 중복값을 제거해야하니, 빈 배열 두개를 만들고, 어떤 값이 들어갓는데 확인하기 위해 cnt를 사용한다.
		
				
		for(int i = 0; i < T; i++) {
			NonDu = new int [11];
			int N = sc.nextInt();
			arr = new int[N];
	
			
			for(int j = 0; j < N; j++) {
			arr[j] = sc.nextInt();
			NonDu[arr[j]]++;
			}
			
			for(int j = 0; j < NonDu.length; j++) {
				if (NonDu[j] > 0) {
					System.out.print(j + " ");
					
				}
			}System.out.println();
			
		}
		
		
		
		
		
		
	}

}
