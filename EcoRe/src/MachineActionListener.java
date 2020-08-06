import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

abstract class MachineActionListener implements ActionListener {
	public JTextField numField;
	public ArrayList<RecycleMachine> listOfMachine;
	
	MachineActionListener(JTextField numField, ArrayList<RecycleMachine> listOfMachine){
		this.numField = numField;
		this.listOfMachine = listOfMachine;	
	}
	
	public int getMachineNum() {
		String numText = numField.getText();
	    int num = Integer.parseInt(numText);
	    return num;
	}
	
	public void actionPerformed(ActionEvent e) {

	}
	
}
