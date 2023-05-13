package in.vini.service;

import in.vini.binding.Passenger;
import in.vini.binding.Ticket;

public interface TicketsService {

	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicket(Integer ticketno);
}
