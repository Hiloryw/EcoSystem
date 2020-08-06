import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CheckEmptyTime extends CheckActionListener {

	public CheckEmptyTime(JTextArea machineField, JTextField numField, ArrayList<RecycleMachine> listOfMachine) {
		super(null, numField, listOfMachine);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int num = getMachineNum();
        RecycleMachine reMachine = listOfMachine.get(num - 1);
        String time = reMachine.getEmptyTime();   

        if (time == null) {
        	String line = "\n\n\tRecycle Machine 0" + num + " has not be emptied! \n";
        	new CreateFrame("Error!",line);
        }
        else {
        	String line2 = "\n\n\tLast Empty Time of Recycle Machine 0" + num + ":\n\t " + time +"\n";
        	new CreateFrame("Last Empty Time", line2);
        }
	}
}