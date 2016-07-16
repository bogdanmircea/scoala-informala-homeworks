package ro.sci.ticketapplication;

/**
 * This is the main class.
 * 
 * @author Bobo
 *
 */
public class TicketApp {

	public static void main(String[] args) throws NotEnoughTicketsException, CategoryEarlyBirdTicketsSoldoutException, TicketsSoldOutExcetion {

		Ticket ticket = new Ticket(100);

		TicketBooth tickets = new TicketBooth();

		tickets.add(ticket);

		tickets.print(ticket);

		tickets.sellTicket(ticket, 100);

		tickets.calculateEarnings();
	}

}
