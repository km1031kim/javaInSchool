package array;
import java.util.Arrays;
import java.util.Random;

public class Array_CalcScore_school {
	public static void main(String[] args) {
		
		int score[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		// int score[] = new int[10];
		
		Random r1 = new Random();
		
		for (int i = 0; i < score.length; i++) {
			score[i] = r1.nextInt(101);
			
			
		}
		
		System.out.println(Arrays.toString(score));
		
		int total = 0;
		
		for (int i = 0; i < score.length; i++) {
			total = total + score[i];
		}
		
		System.out.println(total);
		
		double avg = (double)total / score.length;
		
		avg = Math.round(avg * 100) * 0.01;
		
		System.out.println(avg);
		
		
		
	}

}
