import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

abstract class CheckActionListener implements ActionListener {
	
	public JTextArea machineField;
	public JTextField numField;
	public ArrayList<RecycleMachine> listOfMachine;

	CheckActionListener(JTextArea machineField, JTextField numField, ArrayList<RecycleMachine> listOfMachine) {
		this.machineField = machineField;
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
