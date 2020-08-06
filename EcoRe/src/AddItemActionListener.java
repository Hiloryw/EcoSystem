import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class AddItemActionListener implements ActionListener {
	
	JTextField typeField;
	JTextField priceField;
	HashMap<String, Double> priceMap;
	ArrayList<RecycleMachine> listOfMachine;
	

	public AddItemActionListener(JTextField typeField, JTextField priceField, HashMap<String, Double> priceMap, ArrayList<RecycleMachine> listOfMachine){
		this.typeField = typeField;
		this.priceMap = priceMap;
		this.listOfMachine = listOfMachine;
		this.priceField = priceField;
	}


	public void actionPerformed(ActionEvent e) {
		String newType = typeField.getText();
        String priceText = priceField.getText();
        double newPrice = Double.parseDouble(priceText);
        priceMap.put(newType, newPrice);
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