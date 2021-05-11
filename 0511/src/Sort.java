import java.util.ArrayList;
import java.util.Collections;

public class Sort {
	public static void main(String[] args) {

		ArrayList<Student> arr = new ArrayList<Student>();

		arr.add(new Student("신", 90));
		arr.add(new Student("김", 50));
		arr.add(new Student("진", 40));
		arr.add(new Student("규", 30));
		arr.add(new Student("박", 20));
		arr.add(new Student("최", 10));
		arr.add(new Student("서", 10));
		arr.add(new Student("수", 66));
		arr.add(new Student("영", 44));
		arr.add(new Student("유", 36));


		
		Collections.sort(arr);
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
	}

}
