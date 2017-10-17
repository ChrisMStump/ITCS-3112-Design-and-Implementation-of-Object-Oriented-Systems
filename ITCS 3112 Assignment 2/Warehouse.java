/*
 * Christopher Stump
 * ITCS 3112 Assignment 2
 */
public class Warehouse{
	
	String name;
	int item102, item215, item410, item525, item711;
	
	public Warehouse(String name, int item102, int item215, int item410, int item525, int item711) {
		super();
		this.name = name;
		this.item102 = item102;
		this.item215 = item215;
		this.item410 = item410;
		this.item525 = item525;
		this.item711 = item711;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getItem102() {
		return item102;
	}

	public void setItem102(int item102) {
		this.item102 = item102;
	}

	public int getItem215() {
		return item215;
	}

	public void setItem215(int item215) {
		this.item215 = item215;
	}

	public int getItem410() {
		return item410;
	}

	public void setItem410(int item410) {
		this.item410 = item410;
	}

	public int getItem525() {
		return item525;
	}

	public void setItem525(int item525) {
		this.item525 = item525;
	}

	public int getItem711() {
		return item711;
	}

	public void setItem711(int item711) {
		this.item711 = item711;
	}

	@Override
	public String toString() {
		return name + ": item102:" + item102 + ", item215:" + item215 + ", item410:" + item410
				+ ", item525:" + item525 + ", item711:" + item711;
	}	
}
