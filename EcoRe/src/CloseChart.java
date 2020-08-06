import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CloseChart implements ActionListener {
	private JFrame frame;
	public CloseChart(JFrame frame) {
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
	}
}
