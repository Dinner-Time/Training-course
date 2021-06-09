package 쓰레드;

/*
 * Thread 상속
 * 
 */
public class ThreadTest {

	public static void main(String[] args) {
		Print100 pr100 = new Print100();
		Thread pr1000 = new Thread(new Print1000());
		Thread pr10000 = new Thread(new Print10000());
		Thread pr2000 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 2000; i < 2101; i++) {
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		// 람다식 -> 익명 객체의 구현 매서드가 1개일때
		Thread pr3000 = new Thread(() -> {
			for (int i = 3000; i < 3101; i++) {
				System.out.println(i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		pr100.start();
		pr1000.start();
		pr10000.start();
		pr2000.start();
		pr3000.start();
		
	}

}
