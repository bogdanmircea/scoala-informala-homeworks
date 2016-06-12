package ro.sci.ticketapplication;
/**
 * This is the main class.
 * @author Bobo
 *
 */
public class TicketApp {

	public static void main(String[] args) throws NotEnoughTicketsException {

		Ticket ticket = new Ticket(100);

		TicketBooth tickets = new TicketBooth();

		tickets.add(ticket);

		tickets.print(ticket);

		try {
			tickets.sellTicket(ticket, 65);
		}
		catch (TicketsSoldOutExcetion e) {

			System.out.println("No more Tickets.\n");
		}

		catch (CategoryEarlyBirdTicketsSoldoutException e) {

			System.out.println("No more EarlyBird tickets:\n");
		}

	}
}
