package method;

public class Base_school {
	// 이름, 중간고사, 기말고사 점수 프로퍼티
	String name;
	int middleScore;
	int finalScore;
	int totalScore;
	double evenScore;
	

	// 값을 받아올 생성자 생성
	
	Base_school(String name, int middleScore, int finalScore) {
		this.name = name;
		this.middleScore = middleScore;
		this.finalScore = finalScore;
	}
	
	
	// 총점을 받아줄 메소드 생성
	
	public void totalScore() {
		this.totalScore = this.middleScore + this.finalScore;
		
		
	}
	
	// 평균을 계산할 메소드 생성
	
	public void evenScore() {
		this.evenScore = this.totalScore / (double)2;
	}
	
	// 총점과 평균을 출력해줄 메소드 생성
	
	public void printScore() {
		System.out.println("" + this.name + "의 총점은 = " + this.totalScore + " 평균점수는 = " + this.evenScore);
		
	}

	 //성적순 출력을 위해서 toString 변경
	
	public String toString() {
		return ("" + this.name + "의 점수" +  totalScore);
	}
	
	
}
	

