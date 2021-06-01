package my.project.shape;

public class AppMain {

	public static void main(String[] args) {
//		Shape s = new Rect(4,5);
//		s.area();
//		s.print();
//		
//		s = new Tri(4,5);
//		s.area();
//		s.print();

		Drawable[] s = new Drawable[10];
		s[0] = new Rect(3, 4); // (자식 타입 -> 부모 타입)으로 자동 형변환
		s[1] = new Tri(3, 4); 
		s[2] = new Circle(4);

		for (Drawable temp : s) {
			if (temp == null) {
				break;
			}
			temp.draw();
//			if (temp instanceof Rect) {
//				((Rect)temp).area(); // (부모 타입 -> 자식 타입)으로 강제 형변환
//			} else if (temp instanceof Circle) {
//				((Circle)temp).area();
//			} else if (temp instanceof Tri) {
//				((Tri)temp).area();
//			}
			if (temp instanceof Shape) {
				((Shape)temp).area();
				((Shape)temp).print();
			}
			if (temp instanceof Movable) {
				((Rect)temp).move();
			}
			
		}

	}

}
