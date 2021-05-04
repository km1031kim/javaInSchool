package method;

public class Student_school
{
	// 인적사항 프로퍼티
	private String name;
	private String address;
	private String phone;
	private int age;
	
	
	
	// 생성자, new로 실행했을때 생성되는 부분.
	// 생성자로 인적사항을 한번에 받을 수 있음
	Student_school(String name, String address, String phone, int age) {
		// this. 내부 프로퍼티나 내부 메소드로 이어줌.
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.age = age;
		this.printInfo();
	}
	
	//public - 외부에서 접근 가능
	//private - 객체 내부에서만 접근
	//protected - 내부접근, 상속된 클래스에서만 접근가능
	//deflaut - 아무것도 안적었을때, 같은 패키지 안에서만 접근 가능. 퍼블릭처럼 사용
	private void printInfo() {
	System.out.println("이름 : " + this.name + ", 주소 : " + this.address + ", 연락처 : " + this.name + ", 나이 : " + this.age);
		
	}
	
	// 세터, 게터 - 현대 코딩과는 잘 맞지 않음. 코드가 길어지고 가독성이 떨어짐.
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	// toString 메소드, 숨겨진 object클래스 안 toString 메소드 = 주소를 출력해줌. 그걸 변경
	
//	@Override
//	public String toString() {
//		return "이름 : " + this.name + ", 주소 : " + this.address + ", 연락처 : " + this.name + ", 나이 : " + this.age;
//	
//	}
}


