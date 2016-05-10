package ro.sci.gresieshop;

public class STile extends AbstractRectangularTile {

	public STile(double priceForSTile) {
		super(priceForSTile);
	}
/**
 * The calculate price method does the conversion from square centimeters to square meters and it returns the price in square meters.
 */
	@Override
	public double calculatePrice(double surfaceToCover, double priceForSTile) {
		return surfaceToCover / 1000 * priceForSTile;
	}

	@Override
	public double calculateSplitPrice(double surfaceToCover, double priceForSTile) {
		double splitSurface = surfaceToCover / 2;
		return splitSurface / 1000 * priceForSTile;
	}

}
