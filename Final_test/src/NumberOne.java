import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class NumberOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(",");
		int[] arrInt = new int[arr.length];
		
		String stringDivine = br.readLine();
		int D = Integer.parseInt(stringDivine);
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		
		System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i < arr.length; i++) {
			arrInt[i] = Integer.parseInt(arr[i]);
			
		}
		
		System.out.println(Arrays.toString(arrInt));
		
		// arrInt에서 D로 나눴을 때 나머지가 0인것만 answer에 추가
		
		for(int i = 0; i < arrInt.length; i++) {
			if(arrInt[i] % D == 0) {
				answer.add(arrInt[i]);
			}
			
		}
		
		Collections.sort(answer);
		
		int[] finalAnswer = new int[answer.size()];
		
		for(int i = 0; i < answer.size(); i++) {
			finalAnswer[i] = answer.get(i);
		
		}
		
		System.out.println(Arrays.toString(finalAnswer));
		
	}

}
