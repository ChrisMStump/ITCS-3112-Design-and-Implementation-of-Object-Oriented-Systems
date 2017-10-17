/*
*Christopher Stump
*/
public class Seat {
	String taken;

	public Seat(String taken) {
		super();
		this.taken = taken;
	}

	public String getTaken() {
		return taken;
	}

	public void setTaken(String taken) {
		this.taken = taken;
	}

	@Override
	public String toString() {
		return taken;
	}
	
}
