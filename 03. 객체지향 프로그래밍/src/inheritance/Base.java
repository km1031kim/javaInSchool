package inheritance;

public class Base {
	
	double areaSize = 0;
	String name;
	
	Base(String name) {
		this.name = name;
		
	}

	
	// μΈνλ°μ
	
	
	public void inputData() {
		System.out.println("-------" + this.name + "-------");
		
	}
	
	
	public void areaCalc() {
		
		
	}
	
	public void prinData() {
		this.areaCalc();
		System.out.println(this.areaSize);
	}
}
