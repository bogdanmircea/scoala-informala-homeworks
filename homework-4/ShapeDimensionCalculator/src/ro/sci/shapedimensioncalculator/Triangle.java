package ro.sci.shapedimensioncalculator;

public class Triangle implements Shape {

	private double firstEdge;
	private double secondEdge;
	private double legLength;
	private double area;
	private double perimeter;

	public Triangle(double firstEdge, double secondEdge, double legLength) {
		this.firstEdge = firstEdge;
		this.secondEdge = secondEdge;
		this.legLength = legLength;
	}

	@Override
	public double calculateArea() {
		double semiPerimeter = perimeter / 2;
		area = Math.sqrt((semiPerimeter * (semiPerimeter - legLength) * (semiPerimeter - firstEdge) * (semiPerimeter - secondEdge)));
		return area;
	}

	@Override
	public double calculatePerimeter() {
		perimeter = secondEdge + firstEdge + legLength;
		return perimeter;
	}

	@Override
	public void print() {
		System.out.printf("\nYou have created a triangle with the area of: %.2f\n", area," and the peremiter of: %.2f\n", perimeter);

	}

}
