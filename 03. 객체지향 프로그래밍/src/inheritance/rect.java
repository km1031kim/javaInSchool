package inheritance;
import java.util.Scanner;

public class rect extends Base {
	
	// 요소 받기
	
	double width = 0;
	double height = 0;
	
	rect(String name) {
		super(name);
	}
	
	//계산식
	
	public void inputData() {
		
		super.inputData();
		Scanner s = new Scanner(System.in);
		String height = s.nextLine();
		this.height = Double.parseDouble(height);
		
		Scanner s1 = new Scanner(System.in);
		String width = s1.nextLine();
		this.width = Double.parseDouble(width);
		
	}
	
	public void areaCalc() {
		this.areaSize = width * height;
		
	}

}
