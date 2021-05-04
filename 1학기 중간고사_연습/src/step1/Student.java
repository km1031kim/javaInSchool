package step1;


public class Student {
	String name;
	int middleScore;
	int finalScore;
	
	Student() {
		
	}
	
	Student(String name) {
		this.name = name;
	}
	
	Student(String name, int middleScore, int finalScore) {
		this.name = name;
		this.middleScore = middleScore;
		this.finalScore = finalScore;
	}
	
	@Override
	public String toString() {
		return "" + this.name
				+ " (" + this.middleScore + ", "
				+ this.finalScore + ")";
	}
}
