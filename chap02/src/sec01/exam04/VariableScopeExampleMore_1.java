package sec01.exam04;

public class VariableScopeExampleMore_1 {

	public static void main(String[] args) {
		/*
					## ������ ������ ##
			
		  ������ ���({})���� ��𿡼��� ������ �� ������ ������ ���ĺ���
		  �ڽ��� ���� ��� �������� ����� �� �ִ�.
		 */
		
		// ����� ������ �ٸ� ��Ͽ��� �Ѵٸ�?
		
		int x,y; // x, y ����
		
		x = 10; // x ���� (method ���)
		
		if(x==10) {
			y = 20; // y ���� (if ���)
			int z; // z ���� (if ���)
			System.out.println("y: "+y);
		} // if ��Ͽ��� ����� y�� ���� if ��� �ȿ����� ����Ѵ�.
		  // if ��Ͽ��� ����� z�� method ��Ͽ��� ����� �� ����.
		
		// System.out.println("x: "+x+", y: "+y); // The local variable y may not have been initialized
		
		// z = 30; // z cannot be resolved to a variable
		
		
		
		/*
		 ������ ������ ������ �� ���� ������ ��� �������� Ȱ���� �� �ִ�.
		 ���� ���� ������ ��Ͽ��� ������ �������� ���� ū ������ ��Ͽ� ������ ���� ���Ѵ�.
		 */
	} 

}
