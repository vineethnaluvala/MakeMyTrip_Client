package in.vini.binding;

import lombok.Data;

@Data
public class Ticket {

	private Integer ticketNo;
	private String status;
	private Double price;
	private String name;
	private String from;
	private String to;
	private String doj;
	private String trainNo;
}
