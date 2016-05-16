package ro.sci.shapedimensioncalculator;

public class Circle implements Shape {

	private double radius;
	private double area;
	private double perimeter;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		area = Math.PI * Math.pow(radius, 2);
		return area;
	}

	@Override
	public double calculatePerimeter() {
		perimeter = 2 * Math.PI * radius;
		return perimeter;
	}

	@Override
	public void print() {
		System.out.printf("\nYou have created a circle with the area of: %.2f\n", area, " and the peremiter of: %.2f\n", perimeter);
	}

}
