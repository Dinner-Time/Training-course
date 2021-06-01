package my.project.shape;

public class Rect extends Shape implements Drawable, Movable{
	int h;

	public Rect(int w, int h) {
		super(w);
		this.h = h;
	}

	@Override
	public void area() {
		result = w*h;
	}

	@Override
	public void draw() {
		System.out.println("사각형 그리기");
	}

	@Override
	public void move() {
		System.out.println("사각형이 움직인다!!!");
	}

}
