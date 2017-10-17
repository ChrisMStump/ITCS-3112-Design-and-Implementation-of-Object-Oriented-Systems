/*
 * Christopher Stump
 * ITCS 3112 Assignment 2
 */
import java.io.IOException;

public class Warehouses {

	public static void main(String[] args) throws IOException {
		Inventory warehouse = new Inventory();
		warehouse.getInput();
		warehouse.processTransactions();

	}

}
