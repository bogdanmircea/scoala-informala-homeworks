package ro.sit.houseconsumptionapplication;

public class RectangleRoom implements Room {

	protected double width;
	protected double length;
	protected double area;

	public RectangleRoom(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public double calculateArea() {
		area = getLength() * getWidth();
		return area;
	}

	@Override
	public double calculateConsumption() {

		return area * 33;

	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

}
