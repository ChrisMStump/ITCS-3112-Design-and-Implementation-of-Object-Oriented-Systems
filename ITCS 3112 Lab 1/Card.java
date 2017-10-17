public class Card {
	private String name;

	public Card() {
		name = "";
	}

	public Card(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public boolean isExpired() {
		return false;
	}

	public String format() {
		return "Card holder: " + name;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + "]";
	}

	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (!getClass().equals(other.getClass()))
			return false;
		Card card = (Card) other;
		return name.equals(card.name);
	}
	
}
