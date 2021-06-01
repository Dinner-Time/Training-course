package my.project.shape;

public class Circle extends Shape implements Drawable{

	public Circle(int w) {
		super(w);
	}

	@Override
	public void area() {
		result = w*w*3.14;
	}

	@Override
	public void draw() {
		System.out.println("원 그리기");
	}

}
