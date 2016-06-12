package ro.sit.houseconsumptionapplication;

public class SquareRoom implements Room {

	protected double side;
	protected double area;

	public SquareRoom(double d) {
		this.side = d;
	}

	@Override
	public double calculateArea() {

		area = Math.pow(getSide(), 2);
		return area;
	}

	@Override
	public double calculateConsumption() {

		return area * 33;

	}

	public double getSide() {
		return side;
	}

}
