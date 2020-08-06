

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CreateFrame {
	
	public CreateFrame(String frameName, String textName) {
    	JFrame frame_ = new JFrame(frameName);
		JTextArea errorMsg = new JTextArea(20, 40);
		errorMsg.append(textName);
		frame_.add(errorMsg);
		frame_.pack();
		frame_.setSize(600,200);
		frame_.setVisible(true);
    }
}
