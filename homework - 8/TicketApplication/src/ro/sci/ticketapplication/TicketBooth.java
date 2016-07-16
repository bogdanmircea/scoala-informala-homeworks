package ro.sci.ticketapplication;

import java.util.Map;
import java.util.TreeMap;

/**
 * This is the class where the add Method, sell Method, Print Method are
 * implemented.
 * 
 * @author Bobo
 *
 */
public class TicketBooth {

	String category1 = "Early Bird tickets";
	String category2 = "Normal tickets";
	String category3 = "VIP tickets";

	private int earlyBirdPrice = 50;
	private int normalTicketPrice = 80;
	private int vipTicketPrice = 120;

	Map<String, Integer> tickets = new TreeMap<String, Integer>();

	public void add(Ticket ticket) {

		int x = ticket.getQuantity();
		int ticketQuantity = x;

		int earlyBirdTickets = (ticketQuantity * 50) / 100;
		tickets.put(category1, earlyBirdTickets);

		int normalTickets = (ticketQuantity * 35) / 100;
		tickets.put(category2, normalTickets);

		int vipTickets = (ticketQuantity * 15) / 100;
		tickets.put(category3, vipTickets);

	}

	public void print(Ticket ticket) {
		System.out.println("Available tickets: ");
		for (Map.Entry<String, Integer> ticketinfo : tickets.entrySet()) {
			System.out.println("\t" + ticketinfo.getKey() + ": " + ticketinfo.getValue());
		}
		System.out.println();
	}

	int soldEarlyBirdTicket = 0;
	int soldNormalTicket = 0;
	int soldVipTicket = 0;

	public void sellTicket(Ticket ticket, int soldTickets)
			throws NotEnoughTicketsException, CategoryEarlyBirdTicketsSoldoutException, TicketsSoldOutExcetion {

		int ticketQuantity = ticket.getQuantity();
		for (int i = 0; i <= ticketQuantity; i += soldTickets) {
			if (soldTickets % 17 == 0)
				soldTickets += 3;
		}

		if (soldTickets > ticketQuantity) {
			try {
				throw new NotEnoughTicketsException();
			}
			catch (NotEnoughTicketsException e) {
				System.out.println("You can't buy: " + soldTickets + " tickets. " + "Maximum tickets that can be bought: " + ticketQuantity);
			}
			return;
		}

		int earlyBirdTicketsLeft = (ticketQuantity * 50) / 100;
		int normalTicketsLeft = (ticketQuantity * 35) / 100;
		int vipTicketsLeft = (ticketQuantity * 15) / 100;

		if (soldTickets <= earlyBirdTicketsLeft) {
			soldEarlyBirdTicket = soldTickets;
			earlyBirdTicketsLeft = earlyBirdTicketsLeft - soldTickets;
		}
		else if (soldTickets > earlyBirdTicketsLeft && soldTickets <= (ticketQuantity * 85) / 100) {
			soldEarlyBirdTicket = earlyBirdTicketsLeft;
			soldNormalTicket = soldTickets - earlyBirdTicketsLeft;
			normalTicketsLeft = ticketQuantity - soldTickets - vipTicketsLeft;
			earlyBirdTicketsLeft -= earlyBirdTicketsLeft;
		}
		else if (soldTickets > ((ticketQuantity * 85) / 100) && (soldTickets <= ticketQuantity)) {
			soldEarlyBirdTicket = earlyBirdTicketsLeft;
			soldNormalTicket = normalTicketsLeft;
			soldVipTicket = soldTickets - (earlyBirdTicketsLeft + normalTicketsLeft);

			vipTicketsLeft = earlyBirdTicketsLeft + normalTicketsLeft + vipTicketsLeft - soldTickets;
			earlyBirdTicketsLeft -= earlyBirdTicketsLeft;
			normalTicketsLeft -= normalTicketsLeft;
		}

		int totalTickets = earlyBirdTicketsLeft + normalTicketsLeft + vipTicketsLeft;

		tickets.put(category1, earlyBirdTicketsLeft);
		tickets.put(category2, normalTicketsLeft);
		tickets.put(category3, vipTicketsLeft);

		if (earlyBirdTicketsLeft == 0)
			try {
				throw new CategoryEarlyBirdTicketsSoldoutException();
			}
			catch (CategoryEarlyBirdTicketsSoldoutException e) {
				System.out.println("Early Bird Tickets: SOLD OUT!\n");
			}
		if (normalTicketsLeft == 0)
			try {
				throw new CategoryNormalTicketsSoldoutException();
			}
			catch (CategoryNormalTicketsSoldoutException e) {
				System.out.println("Normal Tickets: SOLD OUT!\n");
			}
		if (totalTickets == 0)
			try {
				throw new TicketsSoldOutExcetion();
			}
			catch (TicketsSoldOutExcetion e) {
				System.out.println("SOLD OUT!\n");
			}
		System.out.println("Tickets sold: " + soldTickets + "\n");
		System.out.println("Tickets left: ");
		System.out.println("\tEarly bird tickets: " + earlyBirdTicketsLeft);
		System.out.println("\tNormal tickets: " + normalTicketsLeft);
		System.out.println("\tVip tickets: " + vipTicketsLeft);
	}

	public void calculateEarnings() {
		System.out.println("Earnings by category: ");
		System.out.println("\tEarly bird tickets: " + soldEarlyBirdTicket * earlyBirdPrice + " lei");
		System.out.println("\tNormal  tickets: " + soldNormalTicket * normalTicketPrice + " lei");
		System.out.println("\tVip tickets: " + soldVipTicket * vipTicketPrice + " lei");
		System.out.println("Total earnings: "
				+ ((soldEarlyBirdTicket * earlyBirdPrice) + (soldNormalTicket * normalTicketPrice) + (soldVipTicket * vipTicketPrice)) + " lei");
	}
}
