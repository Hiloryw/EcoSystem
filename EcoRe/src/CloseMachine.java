import java.awt.event.*;


public class CloseMachine implements ActionListener {
	
	RecycleMachine machine;
	public CloseMachine(RecycleMachine machine) {
		this.machine = machine;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		machine.getView().frame.setVisible(false);
	}

}