package ro.sci.gresieshop;

/**
 * This main class allows you to calculate the price for selling ceramic tiles.
 * <p>
 * You can have three types of tiles:<b> triangular tiles, rectangular tiles
 * sold by piece and rectangular types sold by surface.
 * 
 * 
 * @author Bobo
 *
 */
public class Main {
	/**
	 * @param surfaceToCover
	 *            in square cm;
	 * @param priceForSTile
	 *            is the price for 1 square meter;
	 * @param priceForPTile
	 *            is the price for 1 piece of pTypeTile;
	 * @param pTileLength
	 *            is the length of the pTypeTile tiles;
	 * @param pTileWidth
	 *            is the width of the pTypeTile tiles;
	 * @param priceForTTile
	 *            is the price for 1 piece of tTypeTile;
	 * @param legLength
	 *            is the length of the legLength of tTypeTile;
	 * @param edge
	 *            is the length of one side of tTypeTile;
	 */
	public static void main(String[] args) {

		double surfaceToCover = 6000;
		double priceForSTile = 30;
		double sTileCost = calculateSTileCost(surfaceToCover, priceForSTile);
		double priceForPTile = 25;
		double pTileLength = 20;
		double pTileWidth = 20;
		double pTileCost = calculatePTileCost(surfaceToCover, priceForPTile, pTileLength, pTileWidth);
		double priceForTTile = 30;
		double legLength = 20;
		double edge = 15;
		double tTileCost = calculateTTileCost(surfaceToCover, priceForTTile, legLength, edge);
		double splitCost = calculateSplitCost(surfaceToCover, priceForSTile, priceForPTile, pTileLength, pTileWidth);

		System.out.println("1. Cost for covering the surface with S type tiles: " + sTileCost);

		System.out.println("2. Cost for covering the surface with P type tiles: " + pTileCost);

		System.out.printf("3. Cost for covering the surface with the T type tiles: %.2f\n", tTileCost);

		System.out.println("3. Cost for covering with both rectangular tiles: " + splitCost);
	}

	/**
	 * This method is used to calculate the price for using triangle tiles to
	 * cover the surface.
	 * <p>
	 * <b>The method uses the following parameters: </b>
	 * 
	 * @param surfaceToCover
	 *            is the surface that needs to be covered with ceramic tiles
	 * @param priceForTTile
	 *            is the price for triangle tiles
	 * @param legLength
	 *            is the length of the base of the triangle
	 * @param edge
	 *            is the length of one side of the triangle
	 * @return it returns the price for covering the surface with triangle tiles
	 */
	private static double calculateTTileCost(double surfaceToCover, double priceForTTile, double legLength, double edge) {
		Tile tTypeTile = new TTile(legLength, edge, edge);
		return tTypeTile.calculatePrice(surfaceToCover, priceForTTile);
	}

	/**
	 * This method is used to calculate the price for covering the surface with
	 * rectangular type tiles sold by piece.
	 */
	private static double calculatePTileCost(double surfaceToCover, double priceForPTile, double pTileLength, double pTileWidth) {
		Tile pTypeTile = new PTile(priceForPTile, pTileLength, pTileWidth);
		return pTypeTile.calculatePrice(surfaceToCover, priceForPTile);
	}

	/**
	 * This method is used to calculate the price for covering the surface with
	 * rectangular type tiles sold by surface.
	 */
	private static double calculateSTileCost(double surfaceToCover, double priceForSTile) {
		Tile sTypeTile = new STile(priceForSTile);
		return sTypeTile.calculatePrice(surfaceToCover, priceForSTile);
	}

	/**
	 * This method is used to calculate the price for covering the surface with
	 * both rectangular type tiles.
	 * <p>
	 * Half of the surface will be covered with tiles sold by piece and the
	 * other half will be covered with tiles sold by surface.
	 */
	private static double calculateSplitCost(double surfaceToCover, double priceForSTile, double priceForPTile, double pTileLength, double pTileWidth) {
		Tile pTypeTile = new PTile(priceForPTile, pTileLength, pTileWidth);
		Tile sTypeTile = new STile(priceForSTile);
		return pTypeTile.calculateSplitPrice(surfaceToCover, priceForPTile) + sTypeTile.calculateSplitPrice(surfaceToCover, priceForSTile);
	}

}
