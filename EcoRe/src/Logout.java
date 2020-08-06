import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logout implements ActionListener{
	
	RecycleMonitorStationView view;
	public Logout(RecycleMonitorStationView view) {
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		view.frame.setVisible(false);
		new Login();
	}
}
