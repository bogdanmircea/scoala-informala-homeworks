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

	Ticket ticket = new Ticket();

	String category1 = "Early Bird tickets";
	String category2 = "Normal tickets";
	String category3 = "VIP tickets";

	Map<String, Integer> tickets = new TreeMap<String, Integer>();

	/**
	 * The add method calculates how many tickets we have in each category.
	 * 
	 * @param ticket
	 *            returns the quantity of how many tickets we have.
	 */
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

	/**
	 * The print method just prints our tickets.
	 * 
	 * @param ticket
	 */
	public void print(Ticket ticket) {

		for (Map.Entry<String, Integer> ticketinfo : tickets.entrySet()) {
			System.out.println(ticketinfo.getKey() + ": " + ticketinfo.getValue());
			System.out.println();
		}

	}

	/**
	 * This is the sell method which allows the buyer to buy how many tickets he
	 * wants.
	 * 
	 * @param ticket
	 *            we need this to know the quantity.
	 * @param soldTickets
	 *            represents how many tickets we want to sell.
	 * @throws NotEnoughTicketsException
	 *             if somebody wants to buy more tickets then there are.
	 * @throws CategoryEarlyBirdTicketsSoldoutException
	 *             is thrown when the Early Bird Category is empty.
	 * @throws TicketsSoldOutExcetion
	 *             is thrown when all the tickets are sold.
	 */
	public void sellTicket(Ticket ticket, int soldTickets)
			throws NotEnoughTicketsException, CategoryEarlyBirdTicketsSoldoutException, TicketsSoldOutExcetion {

		int ticketQuantity = ticket.getQuantity();
		// this for loop is for the 17'th customer which will buy 3 tickets.
		for (int i = 0; i <= ticketQuantity; i += soldTickets) {
			if (soldTickets % 17 == 0)
				soldTickets += 3;
		}

		if (soldTickets > ticketQuantity) {
			throw new NotEnoughTicketsException();

		}

		int firstCategory = (ticketQuantity * 50) / 100;
		int secondCategory = (ticketQuantity * 35) / 100;
		int thirdCategory = (ticketQuantity * 15) / 100;

		if (soldTickets <= firstCategory) {
			int soldEarlyBirdTicket = soldTickets;
			System.out.println(firstCategory);
			System.out.println(
					"Sold Early Bird Tickets: " + soldEarlyBirdTicket + " - Price: 50RON " + " - Income: " + (soldEarlyBirdTicket * 50) + "RON");
			System.out.println("Total: " + soldEarlyBirdTicket * 50);
		}
		else if (soldTickets > firstCategory && soldTickets <= (ticketQuantity * 85) / 100) {
			int soldEarlyBirdTicket = firstCategory;
			int soldNormalTicket = soldTickets - firstCategory;
			System.out.println(
					"Sold Early Bird Tickets: " + soldEarlyBirdTicket + " - Price: 50RON " + " - Income: " + (soldEarlyBirdTicket * 50) + "RON");
			System.out.println("Sold Normal Tickets: " + soldNormalTicket + " - Price: 80RON " + " - Income: " + (soldNormalTicket * 80) + "RON");
			System.out.println("Total: " + ((soldEarlyBirdTicket * 50) + (soldNormalTicket * 80)));
		}
		else if (soldTickets > ((ticketQuantity * 85) / 100) && (soldTickets <= ticketQuantity)) {
			int soldEarlyBirdTicket = firstCategory;
			int soldNormalTicket = secondCategory;
			int soldVipTicket = soldTickets - (firstCategory + secondCategory);
			System.out.println(
					"Sold Early Bird Tickets: " + soldEarlyBirdTicket + " - Price: 50RON " + " - Income: " + (soldEarlyBirdTicket * 50) + "RON");
			System.out.println("Sold Normal Tickets: " + soldNormalTicket + " - Price: 80RON " + " - Income: " + (soldNormalTicket * 80) + "RON");
			System.out.println("Sold Vip Tickets: " + soldVipTicket + " - Price: 120RON " + " - Income: " + (soldVipTicket * 120) + "RON");
			System.out.println("Total: " + ((soldEarlyBirdTicket * 50) + (soldNormalTicket * 80) + (soldVipTicket * 120)));
		}
		if (soldTickets <= (ticketQuantity * 50) / 100) {
			firstCategory = firstCategory - soldTickets;

		}

		if ((soldTickets > (ticketQuantity * 50) / 100 && (soldTickets <= ticketQuantity - (ticketQuantity * 15) / 100))) {
			secondCategory = ticketQuantity - soldTickets - thirdCategory;
			firstCategory -= firstCategory;

		}
		else if ((soldTickets > (ticketQuantity * 50) / 100 && (soldTickets >= ticketQuantity - (ticketQuantity * 35) / 100))) {
			thirdCategory = firstCategory + secondCategory + thirdCategory - soldTickets;
			firstCategory -= firstCategory;
			secondCategory -= secondCategory;

		}

		System.out.println("\nTickets sold: " + soldTickets + "\n");

		int totalTickets = firstCategory + secondCategory + thirdCategory;

		tickets.put(category1, firstCategory);
		tickets.put(category2, secondCategory);
		tickets.put(category3, thirdCategory);

		if (firstCategory == 0) {
			throw new CategoryEarlyBirdTicketsSoldoutException();
		}
		if (totalTickets == 0) {
			throw new TicketsSoldOutExcetion();
		}

	}

}
