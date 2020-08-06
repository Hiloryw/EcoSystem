import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;


public class CheckMoney extends CheckActionListener {
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public CheckMoney(JTextArea machineField, JTextField numField, ArrayList<RecycleMachine> listOfMachine) {
		super(machineField,numField, listOfMachine);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int num = getMachineNum();
        RecycleMachine reMachine = listOfMachine.get(num - 1);
        Double leftMoney = reMachine.getLeftMoney();
        machineField.append("\tCurrent money of Recycle Machine 0" + num + ": $" + df2.format(leftMoney) +"\n");
        //machineField.append("Total issued value of Recycle Machine 0" + num + ": " + df2.format(reMachine.getTotalValue()) +"\n");
	}
}