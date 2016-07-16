package ro.sci.ticketapplicationtest;

import org.junit.Test;

import ro.sci.ticketapplication.CategoryEarlyBirdTicketsSoldoutException;
import ro.sci.ticketapplication.NotEnoughTicketsException;
import ro.sci.ticketapplication.Ticket;
import ro.sci.ticketapplication.TicketBooth;
import ro.sci.ticketapplication.TicketsSoldOutExcetion;

/**
 * This is the Test Class were we tested our app.
 * 
 * @author Bobo
 *
 */
public class TicketApplicationTest {

	@Test
	public void testMethods() throws NotEnoughTicketsException, CategoryEarlyBirdTicketsSoldoutException, TicketsSoldOutExcetion {

		Ticket ticket = new Ticket(100);

		TicketBooth tickets = new TicketBooth();

		tickets.add(ticket);

		tickets.print(ticket);

		tickets.sellTicket(ticket, 90);

		tickets.calculateEarnings();
	}

}
