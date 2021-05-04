package ifGrammar;

public class EvenNumber_school {
 public static void main(String[] args) {
	
	 //1부터 10까지 수를 뽑기
	 
	 for (int i = 0; i < 10; i++) {
		 
		 int a = 2;
		 int number1 = i+1;
		 
		 int evenNumber = number1 % a;
		 
		 if (number1 + evenNumber == number1) {
			 System.out.println(number1);
		 }
		 
		 
	 }
	 
 		}
	}
