package in.vini.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.vini.binding.Passenger;
import in.vini.binding.Ticket;
@Service
public class TicketsServiceImpl implements TicketsService {

	private String BOOK_TICKET_URL = "http://localhost:8088/book";
	private String GET_TICKET_URL = "http://localhost:8088/get/{id}";
	@Override
	public Ticket bookTicket(Passenger passenger) {

		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> postForEntity = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		Ticket ticket = postForEntity.getBody();
		
		return ticket;
	}
	@Override
	public Ticket getTicket(Integer ticketno) {
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> forEntity = rt.getForEntity(GET_TICKET_URL, Ticket.class,ticketno);
		Ticket ticket = forEntity.getBody();
		
		return ticket;
	}

}











