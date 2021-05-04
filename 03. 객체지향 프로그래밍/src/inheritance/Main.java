package inheritance;

public class Main {
	public static void main(String[] args) {
		
		//메인을 리스트로 만들자
		Base[] Calculator = {new tri("삼각형"),
							 new parl("평행사변형"),
							 new rhom("마름모"),
							 new cir("원"),
							 new rect("사각형")};
		
	
	
	for(int i = 0; i < Calculator.length; i++) {
		Calculator[i].inputData();
		Calculator[i].prinData();
	}

}
}