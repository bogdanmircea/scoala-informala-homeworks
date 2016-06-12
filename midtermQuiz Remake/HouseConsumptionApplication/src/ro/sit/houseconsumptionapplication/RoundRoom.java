package ro.sit.houseconsumptionapplication;

public class RoundRoom implements Room {

	protected double radius;
	protected double area;

	public RoundRoom(double radius) {
		this.radius = radius;

	}

	@Override
	public double calculateArea() {
		area = Math.PI * Math.pow(getRadius(), 2);
		return area;

	}

	@Override
	public double calculateConsumption() {
		return area * 33;

	}

	public double getRadius() {
		return radius;
	}

}
