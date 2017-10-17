/*
 * Christopher Stump
 * ITCS 3112 Assignment 1
 */
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProcessInfo{
	static String winningNum;
	static StringBuilder temp, name, entry, result;
	static Integer entryCount, place, firstCount, secondCount, thirdCount;
	static ArrayList<Ticket> tickets;
	
	public static void getInput(){
		temp = new StringBuilder();
		name = new StringBuilder();
		entry = new StringBuilder();
		tickets = new ArrayList<Ticket>();
		firstCount = 0;
		secondCount = 0;
		thirdCount = 0;
		
		temp.append(JOptionPane.showInputDialog("Enter the winning ticket number: "));			
		while(!(temp.toString().length() == 6) || !(temp.toString().matches("^[0-9]+$"))) {
			temp.setLength(0);
			temp.append(JOptionPane.showInputDialog("Enter in a valid winning ticket number: "));
			
		}
		winningNum = temp.toString();
		temp.setLength(0);
		
		temp.append(JOptionPane.showInputDialog("Enter the amount of participants: "));
		while(!(temp.toString().matches("^[0-9]+$"))) {
			temp.setLength(0);
			temp.append(JOptionPane.showInputDialog("Enter in a valid amount of participants: "));
		}
		entryCount = Integer.parseInt(temp.toString());
		temp.setLength(0);
		
		for(int i = 0; i < entryCount; i++) {
			name.append(JOptionPane.showInputDialog("Enter participant #" + (i+1) + "'s name: "));
			
			entry.append(JOptionPane.showInputDialog("Enter participant #" + (i+1) + "'s ticket number: "));			
			while(!(entry.toString().length() == 6) || !(entry.toString().matches("^[0-9]+$"))) {
				entry.setLength(0);
				entry.append(JOptionPane.showInputDialog("Enter in a valid ticket number: "));				
			}
			
			temp.setLength(0);
			temp.append(winningNum);
			
			Ticket ticket = new Ticket(name.toString(), entry.toString());			
			
			place = checkTicket(ticket.getTicketNum());
			
			JOptionPane.showMessageDialog(null, "This ticket came in place: " + place);			
			
			ticket.setPlace(place);
			tickets.add(ticket);
			
			if(place == 1) {
				firstCount += 1;
			} else if(place == 2) {
				secondCount += 1;
			} else if(place == 3) {
				thirdCount += 1;
			}
			
			name.setLength(0);
			entry.setLength(0);			
		}
		
		showResult();
	}
	
	public static Integer checkTicket(String ticketNum) {
		if(ticketNum.equals(winningNum)) {
			return 1;
		} else if(ticketNum.equals(temp.reverse().toString())) {
			return 2;
		} else if(matchSeq(ticketNum)) {
			return 3;
		} else {
			return 0;
		}	
	}
	
	public static Boolean matchSeq(String ticketNum) {
		int ticket = Integer.parseInt(ticketNum);
		int winner = Integer.parseInt(winningNum);
		for(int i = 0; i < 4; i++)
	    {
	        if((ticket % 1000) == (winner % 1000))
	            return true;
	        ticket /= 10; winner /= 10;
	    }
	    return false;
	}
	
	public static void showResult() {
		result = new StringBuilder();
		
		result.append("First place winners: " + firstCount + "\n");
		for(Ticket t: tickets) {
			if(t.getPlace() == 1) {
				result.append("\t-" + t.getName() + "\n");
			}
		}
		result.append("Second place winners: " + secondCount + "\n");
		for(Ticket t: tickets) {
			if(t.getPlace() == 2) {
				result.append("\t-" + t.getName() + "\n");
			}
		}
		result.append("Third place winners: " + thirdCount + "\n");
		for(Ticket t: tickets) {
			if(t.getPlace() == 3) {
				result.append("\t-" + t.getName() + "\n");
			}
		}
		JOptionPane.showMessageDialog(null, result.toString());
	}
}
