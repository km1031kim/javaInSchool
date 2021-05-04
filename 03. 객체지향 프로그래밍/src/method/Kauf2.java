package method;

public class Kauf2 { 
	public static void main(String[] args) {
		
		KaufMethod2 kaup = new KaufMethod2();
		
		double weight = kaup.userInputWeight();
		double height = kaup.userInputHeight();
		
		kaup.calcKaup(weight, height);
		
		
		
	
}

}
