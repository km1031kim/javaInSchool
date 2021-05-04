package step4;
import java.util.Random;

public class CC {
	String name;
	Student[] student;

	CC(String name, Student[] student) {
		this.name = name;
		this.student = student;
	}

	// 입력부분
	public void initScore() {
		Random random = new Random();
		for (int i = 0; i < student.length; i++) {
			student[i].middleScore = random.nextInt(1001);
			student[i].finalScore = random.nextInt(1001);
		}
	}

	// 계산부분
	public void calcScore() {
		for (int i = 0; i < student.length; i++) {
			student[i].sumScore();
		}
	}

	int classTotalScore = 0;
	int classTotalMiddleScore = 0;
	int classTotalFinalScore = 0;
	double classAvgTotalScore = 0;

	// 클래스 총합 합산
	public void calcTotal() {
		for (int i = 0; i < student.length; i++) {
			classTotalScore = classTotalScore + student[i].totalScore;
			classTotalMiddleScore = classTotalMiddleScore + student[i].middleScore;
			classTotalFinalScore = classTotalFinalScore + student[i].finalScore;
		}
		classAvgTotalScore = (double) classTotalScore / student.length;
	}

	// 성적 순으로 정렬
	public void sortStudent() {
		for (int i = 0; i < student.length - 1; i++) {
			for (int j = i; j < student.length; j++) {
				if (student[i].totalScore < student[j].totalScore) {
					Student temp = student[i];
					student[i] = student[j];
					student[j] = temp;
				}
			}
		}
	}

	// 순위 세팅
	public void rankSetting() {
		for (int i = 0; i < student.length; i++) {
			if (i > 1 && student[i - 1].totalScore == student[i].totalScore) {
				student[i].rank = student[i - 1].rank;
			} else {
				student[i].rank = i + 1;
			}
		}
	}
	
	// 출력
	public void printData() {
		System.out.println();
		System.out.println(this.name + "의 학생 데이터");
		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i].name 
					+ " 총점 : " + student[i].totalScore 
					+ " (" + student[i].rank + ")");
		}
		System.out.println("반 총점 : " + this.classTotalScore);
		System.out.println("반 평균 : " + this.classAvgTotalScore);
	}
}
