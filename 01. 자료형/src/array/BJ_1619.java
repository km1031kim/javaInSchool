package array;



import java.util.Random;
import java.util.Scanner;

public class BJ_1619 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int dotCount = sc.nextInt();

		int[][] arr = new int[20000][20000];
		int randX = 0;
		int randY = 0;
		int cnt = 1;
		for (int i = 0; i < dotCount; i++) {
			randX = r.nextInt(20000);
			randY = r.nextInt(20000);
			arr[randX][randY] = cnt;
			
			// 중복 제거 해야함.
			cnt++;
		}
//
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int TotalDot = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {

					for (int k = 0; k < arr.length; k++) {
						for (int z = 0; z < arr[k].length; z++) {
							
							int previousCount = 3;
							int lineDot = 0;

							if (arr[k][z] != arr[i][j] && arr[k][z] != 0) {
								// i j 랑 k z 랑 가로 세로 대각선 중 한가지 조건에 겹쳐야 한다.
								if (k == i) {
									// 가로 선을 이었을 때
									// z랑 j 사이에 있는 0이 아닌 수의 개수를 구한다.
									for (int q = 0; q < arr[k].length; q++) {
										if (arr[k][q] != 0) {
											lineDot++;
											
										}

									}
									if (lineDot < 3) {
										continue;
									} else if (lineDot >= 3) {
										if (lineDot >= TotalDot ) {
											TotalDot = lineDot;
											continue;
										} 

									}

								} else if (z == j) {
									// 세로로 선을 이었을 때
									for (int q = 0; q < arr.length; q++) {
										if (arr[q][z] != 0) {
											lineDot++;
										}
									}
									if (lineDot < 3) {
										continue;
									} else if (lineDot >= 3) {
										if (lineDot >= TotalDot) {
											TotalDot = lineDot;
											continue;
										} else if (lineDot < previousCount) {
											continue;
										}
									}

								} else if (Math.abs((double) (k - i) / (double) (z - j)) == 1.0) {
									// 대각선으로 선을 이었을 때

									// 해당 지점과 기울기가 같은 모든 점들..?
									for (int q = 0; q < arr.length; q++) {
										for (int t = 0; t < arr[q].length; t++) {
											if (arr[q][t] != 0) {
												if (Math.abs((double) (k - q) / (double) (z - t)) == 1.0) {
													lineDot++;

												}
											}
										}

									}
									if (lineDot < 3) {
										continue;
									} else if (lineDot >= 3) {
										if (lineDot >= TotalDot) {
											TotalDot = lineDot;
										} else if (lineDot < previousCount) {
											continue;
										}
									}

								}

							}

						}

					}

				}
			}
			
		}if (TotalDot < 3) {
			System.out.println(-1);
		} else if (TotalDot >= 3) {
			System.out.println(TotalDot);
		}
	}

}
