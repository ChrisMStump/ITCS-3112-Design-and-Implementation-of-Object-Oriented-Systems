/*
 * Christopher Stump
 * ITCS 3112 Assignment 2
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Inventory {
	BufferedReader transactionList, inventoryList;
	
	String[] warehouseName;
	Integer[] partsCount;
	ArrayList<Warehouse> warehouseList;
	
	public Inventory() throws FileNotFoundException {
		transactionList = new BufferedReader(new FileReader("Transactions.txt"));
		inventoryList = new BufferedReader(new FileReader("Inventory.txt"));
		warehouseName = new String[]{"Atlanta", "Balitmore", "Chicago", "Denver", "Ely", "Fargo"};
		partsCount = new Integer[]{102, 215, 410, 525, 711};
		warehouseList = new ArrayList<Warehouse>();
	}
	
	public void getInput() throws IOException{
		String sCurrentLine;
		int iterator = 0;
		int iterator2 = 0;
		while((sCurrentLine = inventoryList.readLine()) != null){
			StringTokenizer stok = new StringTokenizer(sCurrentLine, ", ");
			while(stok.hasMoreElements()){
				partsCount[iterator2] = Integer.parseInt((String) stok.nextElement());
				iterator2++;
			}
			Warehouse warehouse = new Warehouse(warehouseName[iterator], partsCount[0], partsCount[1], partsCount[2], partsCount[3], partsCount[4]);
			warehouseList.add(warehouse);
			iterator++;
			iterator2 = 0;
		}	
		iterator = 0;
		StringBuilder sb = new StringBuilder();
		for(Warehouse h: warehouseList){
			System.out.println(h.toString());
			sb.append(h.toString() + "\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString());
	}
	
	public void processTransactions() throws IOException{
		String sCurrentLine, transactionType;
		Integer item, quantity;
		while((sCurrentLine = transactionList.readLine()) != null){
			StringTokenizer stok = new StringTokenizer(sCurrentLine, ", ");
			transactionType = (String) stok.nextElement();
			item = Integer.parseInt((String) stok.nextElement());
			quantity = Integer.parseInt((String) stok.nextElement());
			if(transactionType.equals("P")){
				makePurchase(item, quantity);
				System.out.println("Adding " + quantity + " to " + item);
			} else {
				makeSale(item, quantity);
				System.out.println("Taking " + quantity + " from " + item);
			}
			System.out.println("\n");
			for(Warehouse h: warehouseList){
				System.out.println(h.toString());
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Warehouse h: warehouseList){
			sb.append(h.toString() + "\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString());
	}
	
	public void makePurchase(Integer item, Integer quantity){
		// 102, 215, 410, 525 and 711
		StringBuilder sb = new StringBuilder();
		int lowestIterator = 0;
		int iterator = 0;
		if(item == 102){
			int lowest = warehouseList.get(0).getItem102();
			for(Warehouse h: warehouseList){
				if(h.getItem102() < lowest){
					lowest = h.getItem102();
					lowestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Adding " + quantity + " to item " + item + " in " + warehouseList.get(lowestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(lowestIterator).setItem102(lowest + quantity);
		} else if(item == 215){
			int lowest = warehouseList.get(0).getItem215();
			for(Warehouse h: warehouseList){
				if(h.getItem215() < lowest){
					lowest = h.getItem215();
					lowestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Adding " + quantity + " to item " + item + " in " + warehouseList.get(lowestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(lowestIterator).setItem215(lowest + quantity);
		} else if(item == 410){
			int lowest = warehouseList.get(0).getItem410();
			for(Warehouse h: warehouseList){
				if(h.getItem410() < lowest){
					lowest = h.getItem410();
					lowestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Adding " + quantity + " to item " + item + " in " + warehouseList.get(lowestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(lowestIterator).setItem410(lowest + quantity);
		} else if(item == 525){
			int lowest = warehouseList.get(0).getItem525();
			for(Warehouse h: warehouseList){
				if(h.getItem525() < lowest){
					lowest = h.getItem525();
					lowestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Adding " + quantity + " to item " + item + " in " + warehouseList.get(lowestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(lowestIterator).setItem525(lowest + quantity);
		} else if(item == 711){
			int lowest = warehouseList.get(0).getItem711();
			for(Warehouse h: warehouseList){
				if(h.getItem711() < lowest){
					lowest = h.getItem711();
					lowestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Adding " + quantity + " to item " + item + " in " + warehouseList.get(lowestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(lowestIterator).setItem711(lowest + quantity);
		}
		
	}
	
	public void makeSale(Integer item, Integer quantity){
		// 102, 215, 410, 525 and 711
		StringBuilder sb = new StringBuilder();
		int highestIterator = 0;
		int iterator = 0;
		if(item == 102){
			int highest = warehouseList.get(0).getItem102();
			for(Warehouse h: warehouseList){
				if(h.getItem102() > highest){
					highest = h.getItem102();
					highestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Taking " + quantity + " from item " + item + " in " + warehouseList.get(highestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(highestIterator).setItem102(highest - quantity);			
		} else if(item == 215){
			int highest = warehouseList.get(0).getItem215();
			for(Warehouse h: warehouseList){
				if(h.getItem215() > highest){
					highest = h.getItem215();
					highestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Taking " + quantity + " from item " + item + " in " + warehouseList.get(highestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(highestIterator).setItem215(highest - quantity);
		} else if(item == 410){
			int highest = warehouseList.get(0).getItem410();
			for(Warehouse h: warehouseList){
				if(h.getItem410() > highest){
					highest = h.getItem102();
					highestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Taking " + quantity + " from item " + item + " in " + warehouseList.get(highestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(highestIterator).setItem410(highest - quantity);
		} else if(item == 525){
			int highest = warehouseList.get(0).getItem525();
			for(Warehouse h: warehouseList){
				if(h.getItem525() > highest){
					highest = h.getItem525();
					highestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Taking " + quantity + " from item " + item + " in " + warehouseList.get(highestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(highestIterator).setItem525(highest - quantity);
		} else if(item == 711){
			int highest = warehouseList.get(0).getItem711();
			for(Warehouse h: warehouseList){
				if(h.getItem711() > highest){
					highest = h.getItem711();
					highestIterator = iterator;
				}
				iterator++;
			}
			sb.append("Taking " + quantity + " from item " + item + " in " + warehouseList.get(highestIterator).getName() + "'s warehouse.");
			JOptionPane.showMessageDialog(null, sb.toString());
			warehouseList.get(highestIterator).setItem711(highest - quantity);
		}
	}
}
