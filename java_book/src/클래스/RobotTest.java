package 클래스;

public class RobotTest {

	public static void main(String[] args) {
		
		Robot r = new Robot(2, 4);
//		r.arm = 2;
//		r.leg = 4;
		System.out.println(r.getArm());
		System.out.println(r.getLeg());

		Robot r2 = new Robot(2, 2);
		r2.print();
		System.out.println();
		
		Robot r3 = new Robot(2, 5, "robot");
		r3.print();
	}

}
