/*
 * Christopher Stump
 * ITCS 3112 Assignment 1
 */

public class Ticket {
	String name, ticketNum;
	Integer place;

	public Ticket(String name, String ticketNum) {
		super();
		this.name = name;
		this.ticketNum = ticketNum;
	}

	public Integer getPlace() {
		return place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}
}
