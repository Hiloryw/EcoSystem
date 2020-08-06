import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ActivateActionListener extends MachineActionListener {	
	
	public ActivateActionListener(JTextField numField, ArrayList<RecycleMachine> listOfMachine) {
		super(numField,listOfMachine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int num = getMachineNum();
        RecycleMachine reMachine = listOfMachine.get(num - 1);
        if(reMachine.getStatus() == true) {
        	new CreateFrame("Error!", "\n\n\tMachine is already activated!\n");
        }
        else {
        	reMachine.setStatus(true);
        	new CreateFrame("Activated", "\n\n\tRecycle Machine 0" + num +" operational status: operational ");
        }

	}
}