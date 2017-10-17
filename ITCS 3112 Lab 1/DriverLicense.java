
public class DriverLicense extends Card{
	String expYear;
	
	public DriverLicense(String n, String expiration) {
		super(n);
		expYear = expiration;
	}
	
	public String format() {
		return super.format() + ", Expiration Year: " + expYear;
	}
	
	public boolean isExpired(String year) {
		if(Integer.parseInt(year) > Integer.parseInt(expYear)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "DriverLicense [expYear=" + expYear + "]";
	}
	
	public boolean equals(Object other) {
		if (!super.equals(other))
			return false;
		DriverLicense card = (DriverLicense) other;
		return expYear.equals(card.expYear);
	}	
}
