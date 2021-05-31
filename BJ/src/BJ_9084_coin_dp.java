import java.util.Scanner;

public class BJ_9084_coin_dp {
	public static void main(String[] args) {
		// 스금과 유튜브 10강 활용.
		Scanner sc = new Scanner(System.in);
		int i, j, t = sc.nextInt();
		
		while(t-- > 0){
			int n = sc.nextInt();
			int a[] = new int[n+1];
			for(i=1;i<=n;i++) a[i] = sc.nextInt();
			
			int m = sc.nextInt();
			int d[] = new int[m+1];//테스트케이스만큼 돌려야 하므로 매 케이스마다 선언해 초기화함
			
            d[0] = 1;
			for (i = 1; i <= n; i++)
				for (j = a[i]; j <= m; j++)
					d[j] += d[j - a[i]];
			System.out.println(d[m]);
		}
		sc.close();
	}
}
