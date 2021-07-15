package my.stream.lambda;

// FucntionalInterface
// 구현할 메서드가 하나만 존재하는 인터페이스
interface Run {
	void run();
}

class RunCls implements Run {
	@Override
	public void run() {
		System.out.println("run run runaway runaway baby~~");
	}
}

public class FunctionalEx1 {
	public static void main(String[] args) {
		RunCls cls = new RunCls();
		cls.run();
		
		// interface는 new연산자로 객체생성이 불가능하다. 따라서 메소드를 오버라이드하는 익명객체를 생성해서 new를 사용한다.
		Run r = new Run() {
			@Override
			public void run() {
				System.out.println("You better run run run run run");
			}
		};
		r.run();
		
		// lambda식 활용 방법 (FucntionalInterface에서만 가능)
		Run lam = () -> System.out.println("oK?");
		lam.run();
	}
}
