package ro.sci.gresieshop;

public class PTile extends AbstractRectangularTile {
	/**
	 * This is the class for tiles sold by piece
	 * 
	 * @param priceForPTile
	 *            is the price for one piece
	 * @param pTileLength
	 *            is the length of the tile
	 * @param pTileWidth
	 *            is the width of the tile
	 */
	public PTile(double priceForPTile, double pTileLength, double pTileWidth) {
		super(priceForPTile, pTileLength, pTileWidth);

	}

	/**
	 * The calculate price method uses the calculateArea() method from the super
	 * class to and it dividing the surfaceToCove to the area of one pTypeTile
	 * so you can know how many tiles you need. Then it returns the result of
	 * multiplying the quantity with priceforPTile.
	 * 
	 */
	@Override
	public double calculatePrice(double surfaceToCover, double priceForPTile) {
		double quantity = surfaceToCover / super.calculateArea();
		return quantity * priceForPTile;
	}

	@Override
	public double calculateSplitPrice(double surfaceToCover, double priceForPTile) {
		double splitSurface = surfaceToCover / 2;
		double quantity = splitSurface / super.calculateArea();
		return quantity * priceForPTile;
	}

}
