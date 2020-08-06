import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class OpenMachineActionListener extends MachineActionListener {
	
	public OpenMachineActionListener(JTextField numField, ArrayList<RecycleMachine> listOfMachine) {
		super(numField,listOfMachine);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int num = getMachineNum();
        RecycleMachine reMachine = listOfMachine.get(num - 1);
        if(reMachine.getStatus() == true){
        	reMachine.getView().frame.setVisible(true);
    	}
    	else {
    		new CreateFrame("Error!","\n\n\tMachine is down, please activate first!\n");
    	}

	}

}