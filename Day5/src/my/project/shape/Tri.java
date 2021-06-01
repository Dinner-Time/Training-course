package my.project.shape;

public class Tri extends Shape implements Drawable{
	int h;

	public Tri(int w, int h) {
		super(w);
		this.h = h;
	}

	@Override
	public void area() {
		result = w*h/2;
	}

	@Override
	public void draw() {
		System.out.println("삼각형 그리기");
	}

}
