
public class Voter {
	// 유권자 정보
	String name;
	String address;
	int age;
	String generation;
	
	Voter(String name, String address, int age){
		this.name = name;
		this.address = address;
		this.age = age;
		
		if(age >= 20 && age < 30) {
			this.generation = "20대";
		} else if(age < 40) {
			this.generation = "30대";
		} else if(age < 50) {
			this.generation = "40대";
		} else if(age < 60) {
			this.generation = "50대";
		} else if(age < 70) {
			this.generation = "60대";
		} else if(age < 80) {
			this.generation = "70대";
		} else if(age < 90) {
			this.generation = "80대";
		} else this.generation = ""; // 유권자 나이에 해당되지 않는 경우 공란으로 처리.
	
		
		
		
	}
	

}
