package memberManage;

public class People {
	String name;
	String rank;
	String task;
	long personalNumber;
	
	People(String name, String rank, String task, long personalNumber){
		this.name = name;
		this.rank = rank;
		this.task = task;
		this.personalNumber = personalNumber;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + "님의 사번은" + " " + this.personalNumber + ", " + "직급은 " + this.rank + ", " +  "업무는" + " " +  this.task + "입니다.";

	}
	

}
