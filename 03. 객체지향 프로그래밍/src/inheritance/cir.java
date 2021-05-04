package inheritance;
import java.util.Scanner;

public class cir extends Base {
	
	// 요소 받기
	
	double halflen = 0;
	double pi = 3.14;
	
	//생성자 선언
	cir(String name){
		super(name);
	}
	
	//인풋데이터
	public void inputData() {
		super.inputData();
		Scanner s = new Scanner(System.in);
		String halflen = s.nextLine();
		this.halflen = Double.parseDouble(halflen);
	}

	
		
		public void areaCalc() {
			this.areaSize = halflen * pi;
			
		}
	
	
}

