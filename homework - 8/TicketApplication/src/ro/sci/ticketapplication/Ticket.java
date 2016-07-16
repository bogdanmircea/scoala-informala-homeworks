package ro.sci.ticketapplication;

/**
 * This is the Ticket class.
 * 
 * @author Bobo
 *
 */
public class Ticket {

	protected int quantity;

	public Ticket(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void calculatePrice(int price) {
		System.out.println();
	}

}
