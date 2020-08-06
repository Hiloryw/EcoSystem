import java.awt.event.*;
import javax.swing.*;

public class ButtActionListener implements ActionListener{
	private JButton butt;
	private JButton insert;
    private Item item;
    private JTextField weightField;
    private RecycleMachine machine;

    public ButtActionListener(JButton butt, JButton insert, RecycleMachine machine, JTextField weightField, Item item) {
        this.butt = butt;
        this.insert = insert;
    	this.machine = machine;
        this.weightField = weightField;
        this.item = item;
    }

    public void actionPerformed(ActionEvent e) {
        
        String weightText = weightField.getText();
        double weight = Double.parseDouble(weightText);
	 	double value = item.getValue();
        double totalPrice = item.getPrice();
        double totalWeight = item.getWeight();
               
        if(machine.leftCapacity < weight) {
            new CreateFrame("Error!","\tMachine is full or not enough capacity! \n\tEnd insertion!\n");
            insert.setEnabled(false);
        }   
        
        else { 
            totalPrice = totalPrice + weight * value; 
            totalWeight = totalWeight + weight; 
            //machine.itemNum += 1; 
            double monthlyWeight = machine.getMonthlyWeight();
    		machine.setMonthlyWeight(monthlyWeight + weight);
    		machine.setOnceWeight(weight);
    		item.setWeight(totalWeight);  
            item.setPrice(totalPrice); 
        } 
        
        butt.setEnabled(false);
    }

}