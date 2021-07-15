package baekjoon2667;

import java.util.ArrayList;

class Coordinate {
	int x, y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "("+x+", "+y+")";
	}
	
}

public class MySolution2667 {

	static int countOne; // 1의 갯수
	static int countGroup; // 집합의 갯수
	static ArrayList<Coordinate> list = new ArrayList<Coordinate>(); 

	// 조건에 맞는 배열을 생성하는 매서드
	public static int[][] setting() {
//		int n = ((int)Math.random()*20)+5;

		// 5가 들어가있는 자리에 n을 넣는다.
		int[][] arr = new int[5][5];
		// 배열의 각 자리에 0과 1을 같은 확률로 배치한다.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int) Math.round(Math.random());
			}
		}
		// 결과물을 보여준다.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		return arr;
	}

	// 1의 좌표를 확인하는 매서드
	public static void checkPoint(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					list.add(new Coordinate(j, i));
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr = setting();
		checkPoint(arr);
		for(int i = 0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
		
	}

}
