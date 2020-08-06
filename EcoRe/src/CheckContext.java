import javax.swing.*;

public class CheckContext {
	
	private CheckActionListener checkActionListener;
	public void setCheckStartegy(CheckActionListener checkActionListener) {
		this.checkActionListener =  checkActionListener;
	}
	void executeCheck(JButton butt) {
		butt.addActionListener(checkActionListener);
	}
}
