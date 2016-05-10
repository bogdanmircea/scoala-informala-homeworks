package ro.sci.gresieshop;

public class TTile extends AbstractTriangleTile {

	public TTile(double legLength, double edge, double priceForTTile) {
		super(legLength, edge, edge, priceForTTile);
	}

	@Override
	public double calculateArea() {

		return Math.pow(getEdge(), 2) / 2;
	}

	@Override
	public double calculatePrice(double surfaceToCover, double priceForTTile) {
		double quantity = surfaceToCover / calculateArea();
		return quantity * priceForTTile;
	}

}
