package ro.sci.ticketapplication;
/**
 * This is the Ticket class.
 * @author Bobo
 *
 */
public class Ticket {

	protected int quantity;

	public Ticket(int quantity) {
		this.quantity = quantity;
	}

	public Ticket() {
	}

	public int getQuantity() {
		return quantity;
	}

}
