package stringbuffer;

public class Exec {
	public static void main(String[] args) {
		//String a = "Hello";
		//String b = new String();
		
	//	System.out.println(a.hashCode());
	//	System.out.println(b.hashCode());
		
		// 문자열은 재활용을 위해서 같은 내용이 있으면 같은 메모리 위치를 사용한다.

		
	//	System.out.println(a.hashCode());
		

		
		// 주소 위치는 그대로 쓰고 문자만 추가할 때 쓰는 StringBuffer. 메모리 낭비를 줄일 수 있다.
		StringBuffer c = new StringBuffer("Hello");
		c.append("1");
		System.out.println(c);
		System.out.println(c.reverse());
		c.append("1");
		System.out.println(c);
		System.out.println(c.hashCode());
		
		// c.reverse 단어뒤집기
							
		
//		String charAt(); // 특정 위치의 char 찾기
//		String trim(); //공백 없애기
//		String getBytes(); // 문자열의 내용을 byte[] 로 변환
	}

}
