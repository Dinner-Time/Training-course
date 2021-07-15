package baekjoon10157;
/*
 * 자리배정
 */
public class MySolution10157 {
	
	static int c = 7;
	static int r = 6;
	static int k = 11;
	static int x = 1, y;

	static int[][] stage = new int[r][c];

	public static void setting() {
		
		for (int y = 0; y < stage.length; y++) {
			for (int x = 0; x < stage[y].length; x++) {
				stage[y][x] = 0;
			}
		}
	}

	public static void view() {
		for (int y = 0; y < stage.length; y++) {
			for (int x = 0; x < stage[y].length; x++) {
				System.out.print(stage[y][x] + " ");
			}
			System.out.println();
		}
	}

	public static void up(int inX) {
		for (int i = r - 1; i >= 0; i--) {
			if (k <= 0) {
				return;
			}
			if (stage[i][inX] == 0) {
				stage[i][inX] = 1;
				y++;
				k--;
			}
		}
	}

	public static void right(int inY) {
		for (int i = 0; i < stage[inY].length; i++) {
			if (k <= 0) {
				return;
			}
			if (stage[inY][i] == 0) {
				stage[inY][i] = 1;
				x++;
				k--;
			}
		}
	}

	public static void down(int inX) {
		for (int i = 0; i < stage.length; i++) {
			if (k <= 0) {
				return;
			}
			if (stage[i][inX] == 0) {
				stage[i][inX] = 1;
				y--;
				k--;
			}
		}
	}

	public static void left(int inY) {
		for (int i = c - 1; i >= 0; i--) {
			if (k <= 0) {
				return;
			}
			if (stage[inY][i] == 0) {
				stage[inY][i] = 1;
				x--;
				k--;
			}
		}
	}

	public static void main(String[] args) {
		setting();
//		System.out.printf("width:%d height:%d k:%d\n", c, r, k);

		if (k > r * c) {
			System.out.println(0);
		} else {
			for (int i = 0; i < r; i++) {
				if (k <= 0) {
					break;
				}
				up(x - 1);
				right(i);
				down(x - 1);
				left(r - i - 1);
			}
//			view();
//			System.out.printf("(%d, %d) k:%d", x, y, k);
			System.out.println(x+" "+y);
		}

	}
}
