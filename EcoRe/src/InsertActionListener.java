import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class InsertActionListener implements ActionListener{

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	private ArrayList<JButton> insertButtList;
	private JButton computeButton;
    private RecycleMachine machine;
	private JTextArea detailField;
    private ArrayList<Item> itemList;
    
    public InsertActionListener(ArrayList<JButton> insertButtList, JButton computeButton, RecycleMachine machine, JTextArea detailField, ArrayList<Item> itemList) {
        this.insertButtList = insertButtList;
        this.computeButton = computeButton;
    	this.machine = machine;
        this.detailField = detailField;
        this.itemList = itemList;
    }
    
    public void actionPerformed(ActionEvent e) {
        String title = "\n\t"+"Type \t"+  "weight(lb)\t"  +  "Price($)"+ "\n\n\t";
        String line = "";
        double onceWeight = machine.getOnceWeight();
        for(Item item : itemList) {
            line  = line  + item.getType()+ "\t" + df2.format(item.getWeight()) + "\t"+ df2.format(item.getPrice()) + "\n\t" ;
        }
        
        if (onceWeight > machine.leftCapacity) {
            new CreateFrame("Error!", "\n\n\tMachine is full or not enough capacity!\n\t Please End Insertion!\n");
            
        }
        else {
			machine.itemNum += 1;    
	        detailField.setText(title + line);
	        double leftCapacity = machine.getLeftCapacity()- onceWeight;
			machine.setLeftCapacity(leftCapacity);
			double usedCapacity = machine.capacity - machine.getLeftCapacity();
			machine.setUsedCapacity(usedCapacity);
        }
        
        for(JButton insert : insertButtList) {
        	insert.setEnabled(true);   
        }
        computeButton.setEnabled(true);
    }
   }

