package ro.sci.shapedimensioncalculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		double totalPerimeter = 0;
		double totalArea = 0;

		List<Shape> shapeList = new ArrayList<Shape>();

		Shape triangle = new Triangle(12.3d, 10d, 10d);
		Shape circle = new Circle(11.1d);
		Shape secondSquare = new Square(14.5d);
		Shape square = new Square(17.5d);
		Shape rectangle = new Rectangle(11d, 17d);

		rectangle.calculateArea();
		rectangle.calculatePerimeter();
		rectangle.print();
		shapeList.add(rectangle);

		secondSquare.calculateArea();
		secondSquare.calculatePerimeter();
		secondSquare.print();
		shapeList.add(secondSquare);

		square.calculateArea();
		square.calculatePerimeter();
		square.print();
		shapeList.add(square);

		circle.calculateArea();
		circle.calculatePerimeter();
		circle.print();
		shapeList.add(circle);

		triangle.calculatePerimeter();
		triangle.calculateArea();
		triangle.print();
		shapeList.add(triangle);

		boolean doubleShape = false;

		for (int i = 0; i < shapeList.size() - 1; i++) {
			if (shapeList.get(i).calculateArea() == shapeList.get(i + 1).calculateArea()) {
				doubleShape = true;
			}
		}

		if (doubleShape == false) {
			for (int j = 0; j < shapeList.size(); j++) {
				totalArea += shapeList.get(j).calculateArea();
			}
			System.out.printf("\nTotal area: %.2f\n", totalArea);

			for (int k = 0; k < shapeList.size(); k++) {
				totalPerimeter += shapeList.get(k).calculatePerimeter();
			}
			System.out.printf("\nTotal perimeter: %.2f\n", totalPerimeter);
		}
		else {
			System.out.println("Similar sized shape is already present in the list!");
		}
	}

}
