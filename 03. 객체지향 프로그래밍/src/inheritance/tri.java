package inheritance;
import java.util.Scanner;

public class tri extends Base {
	double upper = 0;
	double height = 0;

	
	tri(String name) {
		super(name);
	}
	
	public void inputData() {
		super.inputData();
		Scanner s = new Scanner(System.in);
		String upper = s.nextLine();
		this.upper = Double.parseDouble(upper);
		
		Scanner s1 = new Scanner(System.in);
		String height = s1.nextLine();
		this.height = Double.parseDouble(height);
		
	}
	
	public void areaCalc() {
		this.areaSize = (upper * height) / (double)2;}

}