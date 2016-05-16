package ro.sci.shapedimensioncalculator;

public class Rectangle implements Shape {

	private double width;
	private double length;
	private double area;
	private double perimeter;

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public double calculateArea() {
		area = width * length;
		return area;
	}

	@Override
	public double calculatePerimeter() {
		perimeter = width * 2 + length * 2;
		return perimeter;
	}

	@Override
	public void print() {
		System.out.println("\nYou have created a rectangle with the area of: " + area + " and the peremiter of: " + perimeter);

	}

}
