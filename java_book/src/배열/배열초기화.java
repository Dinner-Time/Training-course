package 배열;

/*
 배열은 크기가 고정이다
 추가 및 삭제가 번거롭다
 순차적으로 데이터를 저장하고 읽는 용도
 */
public class 배열초기화 {
	public static void main(String[] args) {
		
		//1차원 배열
		int[] a; // -> 배열 선언 (선언한 타입의 값만 저장 가능)
		
		a = new int[10];// -> new (힙 메모리 할당), 미리 배열의 크기를 지정해야한다.
		
		// 배열의 index에 값 저장 -> 일반적으로 for문 활용
		a[0] = 10; 		
		for (int i = 1; i < a.length; i++) {
			a[i] = i;
		}
		
		// 배열 출력
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		// 삭제 (메서드가 따로 없기에 for문을 활용한다.)
		for (int i = 2; i < a.length; i++) {
			a[i-1] = a[i];
		}
		
		// 배열 선언 및 초기화
		int[] b = {0,1,2,3};
		
		// 객체 배열
		
	}
}
