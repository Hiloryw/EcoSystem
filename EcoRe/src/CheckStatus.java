import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CheckStatus extends CheckActionListener {

	public CheckStatus(JTextArea machineField, JTextField numField, ArrayList<RecycleMachine> listOfMachine) {
		super(machineField,numField, listOfMachine);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int num = getMachineNum();
		RecycleMachine reMachine = listOfMachine.get(num - 1);
        boolean status = reMachine.getStatus();
        if(status) {
        	machineField.append("\tStatus of Recycle Machine 0" + num + ": Operational \n");
    	}
    	if(!status) {
    		machineField.append("\tStatus of Recycle Machine 0" + num + ": Down \n");	
    	}
	}
}