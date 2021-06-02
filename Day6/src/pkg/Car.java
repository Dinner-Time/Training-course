package pkg;

public class Car {

	private String model;
	private int speed;
	private boolean stop;

	public Car() {
		super();
	}

	public Car(String model) {
		this(model, 0);
	}

	public Car(int speed) {
		this("none", speed);
	}

	public Car(String model, int speed) {
		super();
		this.model = model;
		if (speed < 50) {
			speed = 50;
		}
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

}
