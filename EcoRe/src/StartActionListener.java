import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class StartActionListener implements ActionListener{
	
	ArrayList<JButton> insertButtList;
	JButton insert;
	JButton computeButton;
	JButton cashButton;
	JButton couponButton;
	JTextArea detailField;
    ArrayList<Item> itemList;
    
    public StartActionListener(ArrayList<JButton> insertButtList, JButton insert, JButton computeButton, JButton cashButton, JButton couponButton, JTextArea detailField, ArrayList<Item> itemList) {
    	this.insertButtList = insertButtList;
        this.insert = insert;
        this.computeButton = computeButton;
        this.cashButton = cashButton;
        this.couponButton = couponButton;
    	this.detailField = detailField;
        this.itemList = itemList;
    }
    
    public void actionPerformed(ActionEvent e) {   
        for (Item item : itemList) {
            item.setWeight(0.0);
            item.setPrice(0.0);
        }
        String title = "\n\t"+"Type\t"+  "weight(lb)\t"  +  " Price($)"+ "\n\n\t";
        String line = "";
        for(Item item : itemList) {
            line  = line + item.getType()+ "\t" + item.getWeight() + "\t"+ item.getPrice()+ "\n\t" ;
        }
        detailField.setText(title + line);
        for (JButton butt: insertButtList) {
			butt.setEnabled(true);
		}
		insert.setEnabled(true);
		computeButton.setEnabled(false);
		cashButton.setEnabled(false);
		couponButton.setEnabled(false);
   }

}