import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener {
	JFrame frame;
	JPanel panel;
	JLabel msg_label, user_label, password_label, message;
	JTextField userName_text;
	JPasswordField password_text;
	JButton submit, cancel;
	RecycleMonitorStation rmos;
   
   public Login() {
      
	  msg_label = new JLabel("Login EcoRecycle System", SwingConstants.CENTER);
	  msg_label.setForeground(Color.BLUE);
	  msg_label.setFont(new Font("Dialog", Font.BOLD, 20)); 
	  // Username Label
      user_label = new JLabel("User Name :");
      user_label.setBounds(120, 40, 100, 25);
      userName_text = new JTextField(5);
      userName_text.setBounds(210, 40, 180, 25);
      // Password Label
      password_label = new JLabel("Password :");
      password_label.setBounds(120, 80, 100, 25);
      password_text = new JPasswordField(5);
      password_text.setBounds(210, 80, 180, 25);
      // Submit
      submit = new JButton("Login");
      submit.setBounds(250, 120, 80, 25);
      panel = new JPanel();
      panel.setLayout(null);
      panel.add(user_label);
      panel.add(userName_text);
      panel.add(password_label);
      panel.add(password_text);
      message = new JLabel();
      panel.add(message);
      panel.add(submit);
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Adding the listeners to components..
      submit.addActionListener(this);

      frame.add(msg_label, BorderLayout.PAGE_START);
      frame.add(panel, BorderLayout.CENTER);
      frame.setTitle("EcoRecycle System");
      frame.setSize(600, 250);
      frame.setVisible(true);
   } 
   
   @SuppressWarnings("deprecation")
   public void actionPerformed(ActionEvent ae) {
      String userName = userName_text.getText();
      String password = password_text.getText();
      if (userName.trim().equals("admin") && password.trim().equals("1234")) { 
			rmos = new RecycleMonitorStation();
			frame.setVisible(false);   
      }
      else {
    	  new CreateFrame("error", "\n\n\tInvalid user or password, please try again!");
         
      }
   }

}