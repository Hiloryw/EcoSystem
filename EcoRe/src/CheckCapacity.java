import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CheckCapacity extends CheckActionListener {

	public CheckCapacity(JTextArea machineField, JTextField numField, ArrayList<RecycleMachine> listOfMachine) {
		super(machineField,numField, listOfMachine);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int num = getMachineNum();
        RecycleMachine reMachine = listOfMachine.get(num - 1);
        Double capacity = reMachine.getLeftCapacity();
        machineField.append("\tCurrent capacity of Recycle Machine 0" + num + ": " + capacity +" lb\n"); 
        if (capacity == 0) {
        	String line = "\n\n\tRecycle Machine 0" + num + " is full and need to be emptied! \n";
        	new CreateFrame("Empty Needed!",line);
        }
	}
}