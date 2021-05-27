package co.yedam.app.score;

public class ForTest {

	public static void main(String[] args) {
		
//		for (int i =0; i<10; i++) {
//			System.out.println(i+"Hello");
//		}
//		
//		for (int i =10; i>0; i--) {
//			System.out.println(i+"Hello");
//		}
//		
//		for (int i =10; i>0; i= i-2) {
//			System.out.println(i+"Hello");
//		}
//		
//		int i =10;
//		for (; i>0; ) {
//			System.out.println(i+"Hello");
//			i= i-2;
//		}
//		
//		while( i>0 ) {
//			System.out.println(i+"Hello");
//			i= i-2;
//		}
		
		for (int i=1; i<=9; i++) {
			System.out.println(i+"단");
			for(int j = 1; j<=9; j++) {
				System.out.print(i*j + "\t");
			}
			System.out.println(" ");
		}
		
		

	}

}
