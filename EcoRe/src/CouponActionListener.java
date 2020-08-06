import java.awt.event.*;
import java.util.*;

public class CouponActionListener extends GetMoneyActionListener {
	
	public CouponActionListener(RecycleMachine machine, ArrayList<Item> itemList){
		 super(machine, itemList);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        
		totalPrice = getTotalPrice();
		if (totalPrice == 0.0) {
			new CreateFrame("Error!", "\n\n\tSorry! No Coupon can be returned!\n");
		}

		else {
			new CreateFrame("Thanks for Recycle!", "\n\n\t Here is your Coupon, \n\t you can use it in local stores!\n\t EcoRe Coupon ###### Value: $"+ df2.format(totalPrice) + " ######");
			double monthlyMoney = machine.getMonthlyMoney();
			machine.setMonthlyMoney(monthlyMoney + totalPrice);
			double totalIssuedMoney = machine.getTotalMoney();
			totalIssuedMoney += totalPrice;
			machine.setTotalMoney(totalIssuedMoney);
			resetItem();
		}	
    }
}