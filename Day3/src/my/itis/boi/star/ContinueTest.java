package my.itis.boi.star;

public class ContinueTest {

	public static void main(String[] args) {
		for (int i=1; i<=10; i++) {
			if (i%2==1) {
				continue;
			}
			System.out.println(i);
		}
	}
}