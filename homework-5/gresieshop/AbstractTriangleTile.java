package ro.sci.gresieshop;

public abstract class AbstractTriangleTile implements Tile {
	// maybe i don't need this class
	private double length;
	private double edge;
	private double edge1;
	private double price;

	public AbstractTriangleTile(double legLength, double edge, double edge1, double priceForTTile) {
		length = legLength;
		this.edge = edge;
		this.edge1 = edge1;
		price = priceForTTile;
	}

	@Override
	public double calculateArea() {
		double s = (getLength() + getEdge() + getEdge1()) / 2;
		return Math.sqrt(s * (s - getLength()) * (s - getEdge()) * (s - getEdge1()));
	}

	public double calculateSplitPrice(double surfaceToCover, double priceForTile) {
		return 0;
	}

	public double getLength() {
		return length;
	}

	public double getEdge() {
		return edge;
	}

	public double getEdge1() {
		return edge1;
	}

}
