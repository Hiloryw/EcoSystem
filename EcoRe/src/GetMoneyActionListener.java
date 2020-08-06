import java.awt.event.*;
import java.text.*;
import java.util.*;

abstract class GetMoneyActionListener  implements ActionListener {
	public static DecimalFormat df2 = new DecimalFormat("#.##");
	public double totalPrice;
	public ArrayList<Item> itemList;
	public RecycleMachine machine;
	
	GetMoneyActionListener( RecycleMachine machine, ArrayList<Item> itemList){
		this.itemList = itemList;
        this.machine = machine;	
	}
	
	public double getTotalPrice() {
		totalPrice = 0.0;
		for(Item item : itemList) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}
	
	public void resetItem() {
		for (Item item : itemList) {
			item.setWeight(0.0);
			item.setPrice(0.0);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
