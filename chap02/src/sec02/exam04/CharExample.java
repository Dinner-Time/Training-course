package sec02.exam04;

public class CharExample {

	public static void main(String[] args) {
		/*
		 �ϳ��� ���ڸ� ''�� ���� ���� ���� ���ͷ��̶��Ѵ�.
		 ���� ���ͷ��� �����ڵ�(2byte ���� : 0 ~ 65535)�� ��ȯ�Ǿ� ����ȴ�.
		 # �����ڵ尡 �����̹Ƿ� charŸ�� ���� ���� Ÿ�Կ� ���Ѵ�.#
		 */
		
		char var1 = 'A'; // �����ڵ� 10���� : 65, 16���� : 0x0041
		System.out.println(var1); 
		char var1_1 = 65;
		System.out.println(var1_1); 
		char var1_2 = 0x0041;
		System.out.println(var1_2); 
		// char�� ����Ÿ���̱� ������ ������ �����ϸ� �ش��ϴ� �����ڵ� ���ڸ� �����´�.
		
		int var2 = 'A'; // int�� ���� ���ͷ��� �����ϸ� �� ���ڿ� �ش��ϴ� �����ڵ� ���ڸ� �����´�.
		System.out.println(var2);
		
	}

}
