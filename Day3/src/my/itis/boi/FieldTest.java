package my.itis.boi;

public class FieldTest {
	int a=10;
	int b= 10;
	
	public void method1() {
		a++;
	}
	
	public static void main(String[] args) {
		FieldTest field = new FieldTest();
		field.method1();
		
		System.out.println(field.a);
	}
}
