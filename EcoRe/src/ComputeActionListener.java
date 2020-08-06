import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class ComputeActionListener implements ActionListener{
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	double totalPrice;
	double totalWeight;
	ArrayList<JButton> insertButtList;
	JButton insert;
	JButton computeButton;
	JButton cashButton;
	JButton couponButton;
	JTextArea detailField;
	ArrayList<Item> itemList;
	RecycleMachine machine;

	public ComputeActionListener(ArrayList<JButton> insertButtList, JButton insert, JButton computeButton, JButton cashButton, JButton couponButton, RecycleMachine machine, ArrayList<Item> itemList, JTextArea detailField){
        this.insertButtList = insertButtList;
        this.insert = insert;
        this.computeButton = computeButton;
        this.cashButton = cashButton;
        this.couponButton = couponButton;
		this.itemList = itemList;
        this.detailField = detailField;
        this.machine = machine;
    }

	public void actionPerformed(ActionEvent e) {
        
		totalPrice = 0.0;
		totalWeight = 0.0;
		for(Item item : itemList) {
			totalPrice += item.getPrice();
		}

		detailField.append("\n\tTotal Value now:  $" + df2.format(totalPrice) + "\n\t");

		for (JButton butt: insertButtList) {
			butt.setEnabled(false);
		}
		insert.setEnabled(false);
		computeButton.setEnabled(false);
		cashButton.setEnabled(true);
		couponButton.setEnabled(true);
	}
}