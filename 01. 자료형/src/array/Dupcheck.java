package array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 0~10 자연수 배열을 중복을 제거하고 오름차순으로 출력하시오.
 */
public class Dupcheck {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("E://input3.txt"));
		Scanner sc = new Scanner(System.in);
		
		// t는 배열의 갯수.
		int T = sc.nextInt();
		int N;
		int[] arr;
		int[] cnt;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			cnt = new int[11]; // 비어있는 배열 생성 
			arr = new int[N]; // 우리가 오름차순 해야 할 배열 생성.
			
//			System.out.println(Arrays.toString(cnt));
//			
//			System.out.println();
//			
			
			// 0부터 10까지 배열 속에 수를 넣어준다.
			for(int i=0; i < N; i++) {
				arr[i] = sc.nextInt(); //arr에 값 넣어주구.
	            cnt[arr[i]]++; //arr[i]값에 대항하는 수를 cnt[요기]에 넣어준다. arr[0]의 값이 1이라면 cnt[1]이 ++ 된다!!
			}
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(cnt));

			for(int i=0; i < 11; i++) {
				if(cnt[i] > 0) System.out.print(i);
			}
////				중복제거 없이 오름차순 출력 
//				if(cnt[i]>0) {
//					for(int j=0; j < cnt[i]; j++) {
//						System.out.print(i);
//					}
//				}
//			}
			System.out.println();

		}
		
		
		


		  
	}

}