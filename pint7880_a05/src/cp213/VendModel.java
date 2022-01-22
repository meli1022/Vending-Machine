package cp213;

import java.util.HashMap;
import java.util.Map;

/**
 * Vending machine model. Contains the algorithms for vending products, handling
 * change and inventory, and working with credit. Should not perform any GUI
 * work of any kind.
 *
 * @author Melissa Pinto
 * @version 2021-03-19
 */
public class VendModel {
	
	//Stores amount of each item in the vending machine
	public static Map<String, String> numberOfItems(){
		Map<String, String> Items = new HashMap<>();
		Items.put("Chocolate", "5");
		 Items.put("Coke", "3");
		 Items.put("Lemonade", "3");
		 Items.put("Sprite", "3");
		 Items.put("Granola Bar", "5");
		 Items.put("Mentos", "4");
		 Items.put("Rice Crispy", "5");
		 Items.put("Cookie", "5");
		 Items.put("Crackers", "5");
		
		return Items;
		
	}
	
	//sStores cost of each item 
	public static Map<String, String> costItems(){
		 Map<String, String> Items = new HashMap<>();
		 Items.put("Chocolate", "3.00");
		 Items.put("Coke", "2.00");
		 Items.put("Lemonade", "3.00");
		 Items.put("Sprite", "2.00");
		 Items.put("Granola Bar", "1.00");
		 Items.put("Mentos", "1.00");
		 Items.put("Rice Crispy", "2.00");
		 Items.put("Cookie", "3.00");
		 Items.put("Crackers", "1.00");
		
		return Items;
		
	}
}