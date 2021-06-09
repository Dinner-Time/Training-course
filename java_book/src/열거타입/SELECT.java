package 열거타입;

public enum SELECT {
	등록(1), 수정(2), 삭제(3), 조회(4), 종료(0);
	
	int value;
	
	SELECT(){}
	
	SELECT(int value) {
		this.value = value;
	}
	
	public static void print() {
		SELECT[] arr = SELECT.values(); // 모든 열거상수를 배열로 만듬
		for (SELECT s : arr) {
			System.out.print(s.value +"."+ s+" ");
		}
	}
	
	public static SELECT getSELECT(int v) {
		SELECT[] arr = SELECT.values();
		for (SELECT s : arr) {
			if(s.value == v) {
				return s;
			}
		}
		return null;
	}
}
