package array;

public class ArrayCopy {
	public static void main(String[] args) {
		
		//배열복사하고 싶을 떄
		int arr[] = {1, 2, 3, 4, 5};
		int arr2[] = new int[arr.length];
		
		System.arraycopy(arr, 0, arr2, 0, arr.length);
	
		
	}
}
 