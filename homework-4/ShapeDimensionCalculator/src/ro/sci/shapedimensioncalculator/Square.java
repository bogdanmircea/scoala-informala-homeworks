package ro.sci.shapedimensioncalculator;

public class Square implements Shape {

	private double edge;
	private double area;
	private double perimeter;

	public Square(double edge) {
		this.edge = edge;
	}

	@Override
	public double calculateArea() {
		area = Math.pow(edge, 2);
		return area;
	}

	@Override
	public double calculatePerimeter() {
		perimeter = 4 * edge;
		return perimeter;
	}

	@Override
	public void print() {
		System.out.println("\nYou have created a square with the area of: " + area + " and the peremiter of: " + perimeter);

	}

}
