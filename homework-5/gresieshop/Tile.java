package ro.sci.gresieshop;
/**
 * This is an interface.
 * @author Bobo
 *
 */

public interface Tile {
	
	double calculatePrice(double surfaceToCover, double priceForTile);
	double calculateArea();
	double calculateSplitPrice(double surfaceToCover, double priceForTile);

}
