package sec01.exam04;

public class VariableScopeExample {

	public static void main(String[] args) {
		/*
		 			## ������ ������ ##
		 			
		  ������ ���({})���� ��𿡼��� ������ �� ������ ������ ���ĺ���
		  �ڽ��� ���� ��� �������� ����� �� �ִ�.
		 */
		
		int v1 = 10; //v1 ���� (method ���)
		
		if (v1>5) {
			int v2;	//v2 ���� (if ���)
			v2 = v1 - 10;
		} //v2 ���� ��
		
		// System.out.println("v1: "+v1+", v2: "+v2); //v2 cannot be resolved to a variable

	} //v1 ���� ��

}
