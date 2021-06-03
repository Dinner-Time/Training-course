package 클래스;

public class RobotTest {

	public static void change(int a) {
		a += 10;
	}
	
	public static void change(Robot robot) {
		robot.setArm(5);

	}

	public static void main(String[] args) {

		Robot r = new Robot(2, 4);
		
		change(r);
		
		System.out.println(r.getArm());
		
		int a= 1;
		change(a);
		System.out.println(a);
//		r.arm = 2;
//		r.leg = 4;
//		System.out.println(r.getArm());
//		System.out.println(r.getLeg());
//
//		Robot r2 = new Robot(2, 2);
//		r2.print();
//		System.out.println();
//
//		Robot r3 = new Robot(2, 5, "robot");
//		r3.print();
	}

}
