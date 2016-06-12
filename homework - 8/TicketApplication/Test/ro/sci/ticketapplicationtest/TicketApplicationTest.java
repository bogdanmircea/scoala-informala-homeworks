package ro.sci.ticketapplicationtest;

import org.junit.Test;

import ro.sci.ticketapplication.CategoryEarlyBirdTicketsSoldoutException;
import ro.sci.ticketapplication.NotEnoughTicketsException;
import ro.sci.ticketapplication.Ticket;
import ro.sci.ticketapplication.TicketBooth;
import ro.sci.ticketapplication.TicketsSoldOutExcetion;
/**
 * This is the Test Class were we tested our app.
 * @author Bobo
 *
 */
public class TicketApplicationTest {

	@Test
	public void testAddMethod() throws NotEnoughTicketsException {

		Ticket ticket = new Ticket(100);

		TicketBooth tickets = new TicketBooth();

		tickets.add(ticket);

		try {
			tickets.sellTicket(ticket, 90);
		}
		catch (TicketsSoldOutExcetion e) {

			System.out.println("No more Tickets.\n");
		}

		catch (CategoryEarlyBirdTicketsSoldoutException e) {

			System.out.println("No more EarlyBird Tickets\n");
		}
	}

}
