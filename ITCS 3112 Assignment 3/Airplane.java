/*
*Christopher Stump
*/
import javax.swing.JOptionPane;

public class Airplane {
	public static void main(String[] args) {
		/*
		 * The airplane has 20 seats in first class (five rows of 4 seats each,
		 * separated by an aisle)
		 */
		Seat firstClassSeats[][] = new Seat[5][4];
		/*
		 * 90 seats in economy class (15 rows of 6 seats each, separated by an aisle).
		 */
		Seat economyClassSeats[][] = new Seat[15][6];
		initialize(firstClassSeats, economyClassSeats);
		while (true) {
			/*
			 * app should take three commands: add passengers, show seating and quit.
			 */
			int choice = Integer.parseInt(JOptionPane.showInputDialog("1. Add passengers \n2. Show Seating \n3. Quit \nEnter your choice:"));
			switch (choice) {
			case 1:
				addPassengers(firstClassSeats, economyClassSeats);
				break;
			case 2:
				showSeating(firstClassSeats, economyClassSeats);
				break;
			case 3:
				System.exit(0);
			}
		}
	}
	
	/*
	 * When passengers are added, ask for the class(first or economy), the number of
	 * passengers traveling together(1 to 2 in first class,1 to 3 in economy), and
	 * the seating preferences(aisle or window in first class,center or window in
	 * economy).
	 */

	/*
	 * Then try to find a match and assign seats.If no match exists, display a
	 * message.
	 */
	private static void addPassengers(Seat[][] firstClassSeats, Seat[][] economyClassSeats)
	{
		String className = JOptionPane.showInputDialog("Enter the class <first or economy>: ");
		int numPassengers=0;
		String preference="";
		boolean match=false;
		if(className.equalsIgnoreCase("first"))
		{
			numPassengers= Integer.parseInt(JOptionPane.showInputDialog("Enter the number of passengers traveling together <1 or 2>: "));
			preference= JOptionPane.showInputDialog("Enter the seating preferences <aisle or window>: ");
			if(preference.equalsIgnoreCase("aisle"))
			{
				if(numPassengers==1)
				{
					for (int i = 0; i < 5; i++) {
						for(int j = 0; j < 4; j++)
							if(j == 1 || j == 2) {
								if(firstClassSeats[i][j].getTaken() == "O") {
									firstClassSeats[i][j].setTaken("A");
									match = true;
								}
								if(match == true) {
									break;
								}
							}
						if(match == true) {
							break;
						}
					}
				}
				else if (numPassengers == 2) {
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 4; j++)
							if (j < 3) {
								if (firstClassSeats[i][j].getTaken() == "O" && firstClassSeats[i][j + 1].getTaken() == "O") {
									firstClassSeats[i][j].setTaken("A");
									firstClassSeats[i][j+1].setTaken("A");
									match = true;
								}
								if (match == true) {
									break;
								}
							}
						if (match == true) {
							break;
						}
					}
				}
			} else if(preference.equalsIgnoreCase("window")) {
				if(numPassengers==1)
				{
					for (int i = 0; i < 5; i++) {
						for(int j = 0; j < 4; j++)
							if(j == 0 || j == 3) {
								if(firstClassSeats[i][j].getTaken() == "O") {
									firstClassSeats[i][j].setTaken("A");;
									match = true;
								}
								if(match == true) {
									break;
								}
							}
						if (match == true) {
							break;
						}
					}					
				}
				else if(numPassengers==2)
				{
					for (int i = 0; i < 5; i++) {
						for(int j = 0; j < 4; j++)
							if(j == 0 || j == 2) {
								if(firstClassSeats[i][j].getTaken() == "O" && firstClassSeats[i][j+1].getTaken() == "O") {
									firstClassSeats[i][j].setTaken("A");
									firstClassSeats[i][j+1].setTaken("A");
									match = true;
								}
								if(match == true) {
									break;
								}
							}
						if (match == true) {
							break;
						}
					}
				}
			}
		}
		else if(className.equalsIgnoreCase("economy"))
		{
			numPassengers= Integer.parseInt(JOptionPane.showInputDialog("Enter the number of passengers traveling together <1 or 2 or 3>: "));
			preference= JOptionPane.showInputDialog("Enter the seating preferences <aisle or window>: ");
			if(preference.equalsIgnoreCase("aisle"))
			{
				if(numPassengers==1)
				{
					for (int i = 0; i < 15; i++) {
						for(int j = 0; j < 6; j++)
							if(j == 2 || j == 3){
								if(economyClassSeats[i][j].getTaken() == "O") {
									economyClassSeats[i][j].setTaken("A");
									match = true;
								}
								if(match == true) {
									break;
								}
							}
						if (match == true) {
							break;
						}
					}
				}
				else if(numPassengers==2)
				{
					for (int i = 0; i < 15; i++) {
						for(int j = 0; j < 6; j++)
							if(j == 1 || j == 2 || j == 3){
								if(economyClassSeats[i][j].getTaken() == "O" && economyClassSeats[i][j+1].getTaken() == "O") {
									economyClassSeats[i][j].setTaken("A");
									economyClassSeats[i][j+1].setTaken("A");
									match = true;
								}
								if(match == true) {
									break;
								}
							}
						if (match == true) {
							break;
						}
					}
				}
				else if(numPassengers==3)
				{
					for (int i = 0; i < 15; i++) {
						for(int j = 0; j < 6; j++)
							if(j == 1 || j == 2){
								if(economyClassSeats[i][j].getTaken() == "O" && economyClassSeats[i][j+1].getTaken() == "O" && economyClassSeats[i][j+2].getTaken() == "O") {
									economyClassSeats[i][j].setTaken("A");
									economyClassSeats[i][j+1].setTaken("A");
									economyClassSeats[i][j+2].setTaken("A");
									match = true;
								}
								if(match == true) {
									break;
								}
							}
						if (match == true) {
							break;
						}
					}
				}
			} else if(preference.equalsIgnoreCase("window")) {
				if(numPassengers==1)
				{
					for (int i = 0; i < 15; i++) {
						for(int j = 0; j < 6; j++)
							if(j == 0 || j == 5){
								if(economyClassSeats[i][j].getTaken() == "O") {
									economyClassSeats[i][j].setTaken("A");
									match = true;
								}
								if(match == true) {
									break;
								}
							}
						if (match == true) {
							break;
						}
					}
				}
				else if(numPassengers==2)
				{
					for (int i = 0; i < 15; i++) {
						for(int j = 0; j < 6; j++)
							if(j == 0 || j == 4){
								if(economyClassSeats[i][j].getTaken() == "O" && economyClassSeats[i][j+1].getTaken() == "O") {
									economyClassSeats[i][j].setTaken("A");
									economyClassSeats[i][j+1].setTaken("A");
									match = true;
								}
								if(match == true) {
									break;
								}
								
							}
						if (match == true) {
							break;
						}
					}
				}
				else if(numPassengers==3)
				{
					for (int i = 0; i < 15; i++) {
						for(int j = 0; j < 6; j++)
							if(j == 0 || j == 3){
								if(economyClassSeats[i][j].getTaken() == "O" && economyClassSeats[i][j+1].getTaken() == "O" && economyClassSeats[i][j+2].getTaken() == "O") {
									economyClassSeats[i][j].setTaken("A");
									economyClassSeats[i][j+1].setTaken("A");
									economyClassSeats[i][j+2].setTaken("A");
									match = true;
								}
								if(match == true) {
									break;
								}
							}
						if (match == true) {
							break;
						}
					}
				}
			}
		}
		if(match==false)
		{
			JOptionPane.showMessageDialog(null, "No match exists");
		}
	}

	/*
	 * shows the seating arrangement and allocated seats so far
	 */
	private static void showSeating(Seat[][] firstClassSeats, Seat[][] economyClassSeats) {
		StringBuilder result = new StringBuilder();
		result.append("Seating Arrangement");
		for (int i = 0; i < 5; i++) {
			result.append("\n");
			for(int j = 0; j < 4; j++) {
				result.append(firstClassSeats[i][j].getTaken() + " ");
			}
		}
		for (int i = 0; i < 15; i++) {
			result.append("\n");
			for(int j = 0; j < 6; j++) {
				result.append(economyClassSeats[i][j].getTaken() + " ");
			}
		}
		JOptionPane.showMessageDialog(null, result.toString());
	}

	private static void initialize(Seat[][] firstClassSeats, Seat[][] economyClassSeats) {
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++)
				firstClassSeats[i][j] = new Seat("O");
		}
		for (int i = 0; i < 15; i++) {
			for(int j = 0; j < 6; j++)
				economyClassSeats[i][j] = new Seat("O");
		}
	}
}