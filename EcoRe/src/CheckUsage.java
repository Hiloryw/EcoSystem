import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CheckUsage extends CheckActionListener {

	public CheckUsage(JTextArea machineField, JTextField numField, ArrayList<RecycleMachine> listOfMachine) {
		super(null, numField, listOfMachine);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int num = getMachineNum();
		RecycleMachine reMachine = listOfMachine.get(num - 1);
		double weight = reMachine.getMonthlyWeight();
    	double money = reMachine.getMonthlyMoney();
    	int emptyNum = reMachine.getEmptyNum();
    	int itemNum = reMachine.getItemNum();
    	
		String line1 = "\n\n\t Weight of Recycle Machine 0" + num  + ": " + weight +" lb";
		String line2 = "\n\n\t Issued money of Recycle Machine 0" + num  + ": $" + money;
		String line3 = "\n\n\t No. of emptied time of Recycle Machine 0" + num  + ": " + emptyNum;
		String line4 = "\n\n\t No. of returned items of Recycle Machine 0" + num  + ": " + itemNum;
    	new CreateFrame("Monthly Usage Statistics for RCM 0"+ num, line1+line2+line3+line4);	
    	String title = "Monthly Usage Statistics for RCM 0"+ num;
    	
    	new CreateChart(title, weight, money, emptyNum, itemNum);
	}
}
