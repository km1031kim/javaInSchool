package array;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Quiz {
	public static void main(String[] args) {

		int arr[][] = { { 10, 33, 44 }, { 27, 5, 98 } };

		// 2 X 3 배열이구나!
		for (int i = 0; i < arr.length; i++) {
			double avg = 0;
			int sum = 0;

			System.out.println();

			for (int j = 0; j < arr[i].length; j++) {
				sum = sum + arr[i][j];

				System.out.print(arr[i][j] + " ");
			}

			avg = sum / (double) arr[i].length;
			System.out.println(" " + sum + " " + Math.round(avg * 10) / (double) 10); // 원하는 자리에서 반올림하는거 잘 기억하자.

			// 각각의 토탈을 구해야 한다. 즉 arr[0][0]값과 arr[1][0] 값
			// arr[0][1]값과 arr[1][1] 값
			// arr[0][2]값과 arr[1][2] 값

		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			int eachQuizTotal = 0;
			for (int j = 0; j < 2; j++) {
				eachQuizTotal = eachQuizTotal + arr[j][i];
			}
			System.out.print(eachQuizTotal + " ");
		}
		System.out.println();
		int score[][] = new int[2][4];
		for (int i = 0; i < score.length; i++) {
			System.out.println();
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + " ");
			}
		}

		// 그냥 복사하면 전체 복사가 안된다. 반복문을 이용해야한다.
		for (int i = 0; i < score.length; i++) {
			System.arraycopy(arr[i], 0, score[i], 0, arr[i].length);

		}
		System.out.println();

		for (int i = 0; i < score.length; i++) {
			System.out.println();
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + " ");
			}
		}
		System.out.println();

		// 0,3 과 1,3 에 각각의 총합을 더해주자.
		for (int i = 0; i < score.length; i++) {
			int eachtotal = 0;
			for (int j = 0; j < score[i].length; j++) {
				eachtotal = eachtotal + score[i][j];
			}
			score[i][3] = eachtotal;
			System.out.println();
			for (int k = 0; k < score[i].length; k++) {
				System.out.print(score[i][k] + " ");
			}

		}

		// 이제 내림차순 해보자!
		// score[i][j] < score[i][j+1]
		// temp = score[i][j]
		// score[i][j] = score[i][j+1]
		// score[i][j+1] = temp

		for (int i = 0; i < score[0].length - 1; i++) {
			for (int j = i + 1; j < score[0].length; j++) {
				if (score[0][i] < score[0][j]) {
					int temp = 0;
					temp = score[0][i];
					score[0][i] = score[0][j];
					score[0][j] = temp;
				}
			}
		}

		for (int i = 0; i < score[1].length - 1; i++) {
			for (int j = i + 1; j < score[1].length; j++) {
				if (score[1][i] < score[1][j]) {
					int temp = 0;
					temp = score[1][i];
					score[1][i] = score[1][j];
					score[1][j] = temp;
				}
			}
		}

		System.out.println();

		for (int i = 0; i < score.length; i++) {
			System.out.println();
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + " ");
			}
		}

	}

}