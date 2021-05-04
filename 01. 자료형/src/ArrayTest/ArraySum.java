package ArrayTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArraySum {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("E://input2.txt"));

		// TODO Auto-generated method stub
		int n, m, k, sum = 0;
		int[][] map;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map  = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		k = sc.nextInt();
		for(int i=0; i < k;i++) {
			sum = 0;
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int a=x1; a<=x2; a++) {
				for(int b=y1; b<=y2; b++) {
					sum += map[a][b];
				}
			}
			System.out.println(sum);
		}
		
		
	}

}
