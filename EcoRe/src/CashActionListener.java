import java.awt.event.*;
import java.util.*;

public class CashActionListener extends GetMoneyActionListener {

	public CashActionListener( RecycleMachine machine, ArrayList<Item> itemList){
        super(machine, itemList);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {   
		totalPrice = getTotalPrice();
		if(totalPrice == 0.0) {
			new CreateFrame("Error!", "\n\n\tSorry! No cash can be returned!\n");
		}
		
		if (totalPrice > machine.leftMoney && totalPrice > 0.0) {
			new CreateFrame("Error!", "\tNot enough Cash, \n\tPlease choose Coupon instead!\n");
		}	

		if (totalPrice <= machine.leftMoney && totalPrice > 0.0) {
			
			double monthlyMoney = machine.getMonthlyMoney();
			machine.setMonthlyMoney(monthlyMoney + totalPrice);
			
			machine.leftMoney = machine.leftMoney - totalPrice;
			double totalIssuedMoney = machine.getTotalMoney();
			totalIssuedMoney += totalPrice;
			machine.setTotalMoney(totalIssuedMoney);
			new CreateFrame("Thanks for Recycle!", "\tPlease Take the Cash for you!\n\t $"+ df2.format(totalPrice));
			resetItem();
		}
		
    }
       
}