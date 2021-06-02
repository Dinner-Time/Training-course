package pkg.inheritence;

public class MainApp {

	public static void main(String[] args) {
		
		A a = new E();
		char temp = ((C)a).c;
		System.out.println(temp);
		
//		A o = new A();
//		temp = ((D)o).d; // 실행 오류(runtime 오류)
		
		
 	}

}
