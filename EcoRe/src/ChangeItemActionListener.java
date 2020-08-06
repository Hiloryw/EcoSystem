import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class ChangeItemActionListener implements ActionListener {
	
	JTextField oldtypeField;
	JTextField newtypeField;
	HashMap<String, Double> priceMap;
	ArrayList<RecycleMachine> listOfMachine;

	public ChangeItemActionListener(JTextField oldtypeField, JTextField newtypeField, HashMap<String, Double> priceMap, ArrayList<RecycleMachine> listOfMachine){
		this.oldtypeField = oldtypeField;
		this.priceMap = priceMap;
		this.listOfMachine = listOfMachine;
		this.newtypeField = newtypeField;
	}


	public void actionPerformed(ActionEvent e) {
		String oldType = oldtypeField.getText();
        String newType = newtypeField.getText();
        double price = priceMap.get(oldType);
        priceMap.remove(oldType);
        priceMap.put(newType, price);
   
        for(RecycleMachine machine : listOfMachine) {
        	machine.setPriceMap(priceMap);
        	RecycleMachineView view = machine.getView();
        	view.frame.setVisible(false);
        	priceMap = machine.getPriceMap();
        	view.update(machine, priceMap);
        	machine.getView();

        }

	}
}
