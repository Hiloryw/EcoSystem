import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class AddNewMachineActionListener implements ActionListener {

	private JTextArea machineField;
	private int machineNum  = 2;
	private HashMap<String, Double> priceMap = new HashMap<String, Double>();
	private ArrayList<RecycleMachine> listOfMachine;
	private ArrayList<String> locationList;
	private ArrayList<String> idList;
	private boolean status;
	private double setMoney;
	private double setCapacity;

	public AddNewMachineActionListener(JTextArea machineField, ArrayList<String> locationList, ArrayList<String> idList, HashMap<String, Double> priceMap, ArrayList<RecycleMachine> listOfMachine, boolean status, double setMoney, double setCapacity) {
		this.machineField = machineField;
		this.priceMap = priceMap;
		this.listOfMachine = listOfMachine;
		this.locationList = locationList;
		this.idList = idList;
		this.status = status;
		this.setMoney = setMoney;
		this.setCapacity = setCapacity;

	}

	public void actionPerformed(ActionEvent e) {
		
		String line = "\n\tNew Recyce machine "+" created!\n\tList of Machines:\n\n";
		String location = locationList.get(machineNum);
		String id = idList.get(machineNum);
		
		RCMFactory rcmFactory = new RCMFactory();
		
		RecycleMachine reMachine = rcmFactory.createMachine().getMachine(priceMap, location, id, status, setMoney, setCapacity);
		RecycleMachineView view = rcmFactory.createView().getView(reMachine, priceMap, location, id);
		reMachine.setView(view);
		
		machineNum += 1;
		reMachine.setMachineNum(machineNum);
		listOfMachine.add(reMachine);
		for(RecycleMachine machine : listOfMachine) {
			int i = machine.getMachineNum();
			String newLine = "\tRecycle Machine 0"+ i + "  Location: " + machine.getLocation() + "  Id: "+ " " + machine.getId()+" \n";
			line = line + newLine;	
		}
		machineField.setText(line);
		
	}

}