package inheritance;
import java.util.Scanner;

public class parl extends Base {
	
	double upper = 0;
	double lower = 0;
	double height = 0;

	parl(String name) {
		super(name);
	}
	
	
	public void inputData() {
		super.inputData();
		Scanner s = new Scanner(System.in);
		String upper = s.nextLine();
		this.upper = Double.parseDouble(upper);
		
		Scanner s1 = new Scanner(System.in);
		String lower = s1.nextLine();
		this.lower = Double.parseDouble(lower);
		
		Scanner s2 = new Scanner(System.in);
		String height = s2.nextLine();
		this.height = Double.parseDouble(height);
	}

		public void areaCalc() {
			this.areaSize = this.upper + this.lower * this.height / (double)2;
			
		}
		
		
	}

