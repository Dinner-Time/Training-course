package sec01.exam03;

public class VariableExchangeExample {

	public static void main(String[] args) {
		/* 
		 �� ����(x,y)�� ���� ��ȯ�ϴ� ���
		 ���ο� ����(temp)�� ����� �ϳ��� ����(x)�� �����ϰ�,
		 �� ����(x)�� �ٸ� �ϳ��� ����(y)�� �����ϰ�,
		 �� ����(y)�� (x)�� ������ (temp)�� �����Ѵ�.
		 */
		
		int x,y; // ���� x,y�� ����
		x = 10; // x�� 10�� ���� (x = 10)
		y = 20; // y�� 20�� ���� (x = 10, y = 20)
		System.out.println("x: " + x + ", y: " + y);
		
		int temp; // ���� temp�� ����
		temp = x; // ���� temp�� x�� ���� (x=10, y=20, temp(=x)=10)

		x = y; // ���� x�� ���� y�� ���� (x(=y)=20, y=20 , temp=10)
		y = temp; // ���� y�� temp(x�� ������ ����)�� ���� (x=20, y(=temp)=10, temp=10)
		
		System.out.println("x: " + x + ", y: " + y);

	}

}
