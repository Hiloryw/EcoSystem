import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 

public class EmptyActionListener extends MachineActionListener {
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	 

	public EmptyActionListener(JTextField numField, ArrayList<RecycleMachine> listOfMachine) {
		super(numField,listOfMachine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int num = getMachineNum();
        RecycleMachine reMachine = listOfMachine.get(num - 1);
        Double capacity = reMachine.getLeftCapacity();
        
        if (capacity == 0) {
        	reMachine.setLeftCapacity(reMachine.capacity);
        	Date date = new Date();
        	String emptyTime = format.format(date);
        	reMachine.setEmptyTime(emptyTime);
        	
        	int emptyNum = reMachine.getEmptyNum();
        	reMachine.setEmptyNum(emptyNum + 1);
        	
        	String line = "\n\n\tRecycle Machine 0" + num + " has been emptied! \n\n\tCapacity now: " + reMachine.getLeftCapacity() + " lb\n\n\t" + reMachine.getEmptyTime();
        	new CreateFrame("Empty Completed!",line);
        }

        else {
        	String line = "\n\n\tMachine is not full! No need to empty! \n\n\t";
        	new CreateFrame("Error!", line);
        }
	}
}