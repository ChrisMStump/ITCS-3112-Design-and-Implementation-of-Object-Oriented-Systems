
public class IDCard extends Card{
	String idNum;
	
	public IDCard(String n, String id) {
		super(n);
		idNum = id;
	}

	public String format() {
		return super.format() + ", ID: " + idNum;
	}

	@Override
	public String toString() {
		return "IDCard [idNum=" + idNum + "]";
	}

	public boolean equals(Object other) {
		if (!super.equals(other))
			return false;
		IDCard card = (IDCard) other;
		return idNum.equals(card.idNum);
	}
}
