package ro.sci.gresieshop;

/**
 * This is the Abstract Class for every rectangular type tile that will be
 * created and it implements the Tile interface.
 * 
 * @author Bobo
 *
 */
public abstract class AbstractRectangularTile implements Tile {

	private double length;
	private double width;
	private double price;

	/**
	 * This is a constructor that will be used for creating sType tiles.
	 * 
	 * @param priceForSTile
	 *            for this type of tiles we need only the price parameter. The
	 *            price for this type of tiles is for 1 square meter.
	 */
	public AbstractRectangularTile(double priceForSTile) {
		price = priceForSTile;
	}

	/**
	 * This constructor is used to create the tiles that will be sold by piece.
	 * 
	 * @param priceForPTile
	 *            the price is set to one piece of pType tiles.
	 * @param pTileLength
	 *            is the length of the tile
	 * @param pTileWidth
	 *            is the width of the tile
	 */
	public AbstractRectangularTile(double priceForPTile, double pTileLength, double pTileWidth) {
		length = pTileLength;
		width = pTileLength;
		price = priceForPTile;
	}

	@Override
	public double calculateArea() {
		return this.getLength() * this.getWidth();
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

}
