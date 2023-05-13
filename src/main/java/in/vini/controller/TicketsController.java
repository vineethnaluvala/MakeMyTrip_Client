package in.vini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.vini.binding.Passenger;
import in.vini.binding.Ticket;
import in.vini.service.TicketsServiceImpl;

@Controller
public class TicketsController {
	@Autowired
	private TicketsServiceImpl service;

	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";
	}

	@PostMapping("/book")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger, Model model) {

		System.out.println(passenger);
		Ticket bookTicket = service.bookTicket(passenger);

		model.addAttribute("msg", "your ticket booked succesfully with number : " + bookTicket.getTicketNo());
		return "index";

	}

	@GetMapping("/ticket")
	public String getTicket(Model model) {
		model.addAttribute("ticket", new Ticket());

		return "viewticket";

	}

	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketno, Model model) {
		System.out.println(ticketno);
		Ticket ticket = service.getTicket(ticketno);
		model.addAttribute("ticket", ticket);

		return "viewticket";

	}

}
