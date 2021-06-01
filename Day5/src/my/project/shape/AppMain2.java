package my.project.shape;

public class AppMain2 {
	public static void main(String[] args) {
		Shape s = new Rect(4, 5);
		execute(s);

//		s = new Circle(4);
//		execute(s);

	}

	public static void execute(Shape s) {
		if (s instanceof Drawable) {
			((Drawable) s).draw();
		}
		if (s instanceof Movable) {
			((Movable) s).move();
		}
		s.area();
		s.print();
	}
}
