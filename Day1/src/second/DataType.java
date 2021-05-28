package second;

public class DataType {
	void sum(int a, int b) {
		System.out.println(a+b);
	}
	
	void suml(long a, long b) {
		System.out.println("long"+(a+b));
	}
	
	void sumd(double a, double b) {
		System.out.println("double" + (a+b));
	}
	
	void upper(char a) {
		int b = (int)a - 32;
		System.out.println((char)b);
	}
	
	void sum8(int a, int b) {
		int x = a + b;	
		System.out.println(Integer.toOctalString(x));
	}
	
	void sum16(int a, int b) {
		int x = a + b;	
		System.out.println(Integer.toHexString(x));
	}
	
}
