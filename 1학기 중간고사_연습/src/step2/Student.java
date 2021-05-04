package step2;
public class Student {
	String name;
	int middleScore;
	int finalScore;
	int totalScore;
	double avgScore;
	
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
	
	public void sumScore() {
		this.totalScore = this.middleScore + this.finalScore;
		this.avgScore = this.totalScore / (double)2;
	}
	
	@Override
	public String toString() {
		return "" + this.name
				+ " (" + this.middleScore + ", "
				+ this.finalScore + ")";
	}
}
