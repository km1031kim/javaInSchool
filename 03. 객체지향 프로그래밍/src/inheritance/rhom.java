package inheritance;
import java.util.Scanner;

public class rhom extends Base {
	
	double width = 0;
	double height = 0;
	
	
	rhom(String name) {
		super(name);
	}
	
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
		this.areaSize = this.width * this.height / 2;
		
	}

	
}
