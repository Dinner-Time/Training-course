package my.itis.boi.score;

public class ArrApp {
	int[] arr = new int[10]; // 배열은 선언할 때 크기를 정해줘야 한다.

	void init() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}
	}

	void print() {
		// 출력
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}

		System.out.println();
	}

	int arrSum() {
		// 합계
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	int arrMax() {
		// 최대
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	int arrMin() {
		// 최소
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) {

//		init();
//		print();
//		System.out.printf("합계: %d\n최대: %d\n최소: %d"
//				, arrSum(), arrMax(), arrMin());
	}
}
