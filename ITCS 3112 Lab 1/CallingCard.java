
public class CallingCard extends Card{
	String cardNum, PIN;
	
	public CallingCard(String n, String cardNumber, String pinNum) {
		super(n);
		cardNum = cardNumber;
		PIN = pinNum;
	}
	
	public String format() {
		return super.format() + ", Card Number: " + cardNum + ", PIN Number: " + PIN;
	}

	@Override
	public String toString() {
		return "CallingCard [cardNum=" + cardNum + ", PIN=" + PIN + "]";
	}
	
	public boolean equals(Object other) {
		if (!super.equals(other))
			return false;
		CallingCard card = (CallingCard) other;
		return cardNum.equals(card.cardNum) && PIN.equals(card.PIN);
	}
}
