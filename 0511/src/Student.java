
public class Student implements Comparable<Student> {
	String name;
	int score;
	
	Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + "님의 성적은" + " " + this.score + "점 입니다";
				
	}
	@Override
	public int compareTo(Student o) { // o는 나와 다른 객체. compare가 알아서 비교해줌.
		if (this.score < o.score) {
			return 1; // 앞으로 가기
		} else if(this.score > o.score) {
			return -1; // 뒤로가기
		}
		return 0; // 그대로
	}


}
  