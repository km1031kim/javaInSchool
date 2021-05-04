package step4;
public class Student {
	String name;
	int middleScore;
	int finalScore;
	int totalScore;
	double avgScore;
	int rank;

	Student(String name) {
		this.name = name;
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
