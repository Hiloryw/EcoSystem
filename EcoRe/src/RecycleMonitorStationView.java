
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 

public class RecycleMonitorStationView {

	JFrame frame;
	private JPanel head, buttList, text, check, addlist, changelist;
	private JButton logoutButt, addItemButton, createButton, changeItemButton;
	private JTextField numField, typeField, oldtypeField, newtypeField, priceField;
	private JLabel addlabel, addItemLabel, addTypeLabel, addPriceLabel;
	private JLabel titleLabel, oldTypeLabel, changeItemLabel, newItemLabel, checkcollabel, checkLabel;
	private JButton statusCheckButton, activateButton, openMachineButton, moneyCheckButton, capacityCheckButton, emptyButton, emptiedTimeButton, usageButton;
	private JTextArea machineField;

	public RecycleMonitorStationView(ArrayList<String> locationList, ArrayList<String> idList, HashMap<String, Double> priceMap, ArrayList<RecycleMachine> listOfMachine, boolean setStatus, double setMoney, double setCapacity){
		
		head = new JPanel();
		head.setBackground(new Color(173, 216, 230));
		titleLabel = new JLabel("Recycle Monitor Station", SwingConstants.CENTER);
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Apple", Font.BOLD, 36));
		logoutButt = new JButton("Log out");
	
		head.add(titleLabel);
		head.add(logoutButt);
		
		addlabel = new JLabel("Add/Change", SwingConstants.CENTER);
		addlabel.setFont(new Font("Apple", Font.BOLD, 18));
		addlabel.setForeground(Color.RED);
		
		createButton =  new JButton(" Add a new RCM!");
		addItemLabel = new JLabel("Add New Item Type", SwingConstants.CENTER);
		addItemLabel.setFont(new Font("Apple", Font.BOLD, 14));
		addTypeLabel = new JLabel("Input Item Type:", SwingConstants.CENTER);
		typeField =  new JTextField(5);
		addPriceLabel = new JLabel("Input Item Price:", SwingConstants.CENTER);
		priceField =  new JTextField(5);
    	addItemButton = new JButton(" Add ");
    	changeItemLabel = new JLabel("Change Item Type", SwingConstants.CENTER);
    	changeItemLabel.setFont(new Font("Apple", Font.BOLD, 14));
		oldTypeLabel = new JLabel("Input Old Item Type:", SwingConstants.CENTER);
		oldtypeField =  new JTextField(5);
		newItemLabel = new JLabel(" Input New Item Type:", SwingConstants.CENTER);
		newtypeField =  new JTextField(5);
    	changeItemButton = new JButton(" Change ");

    	buttList = new JPanel(new GridLayout(2, 1));
    	addlist = new JPanel(new GridLayout(0, 1));
    	changelist = new JPanel(new GridLayout(0, 1));
    	
    	
		addlist.add(addlabel);
		addlist.add(createButton);
		addlist.add(addItemLabel);
		addlist.add(addTypeLabel);
		addlist.add(typeField);
		addlist.add(addPriceLabel);
		addlist.add(priceField);
		addlist.setBackground(new Color(255,255,224));
		buttList.add(addlist);
		
		changelist.add(addItemButton);
		changelist.add(changeItemLabel);
		changelist.add(oldTypeLabel);
		changelist.add(oldtypeField);
		changelist.add(newItemLabel);
		changelist.add(newtypeField);
		changelist.add(changeItemButton);
		changelist.setBackground(new Color(255,255,224));
		buttList.add(changelist);
		
		text = new JPanel();
		machineField = new JTextArea(50, 60); 
		text.add(machineField, BorderLayout.CENTER);

		check = new JPanel(new GridLayout(12, 1));
		check.setBackground(new Color(227,251,227));
		numField = new JTextField(10);
		checkcollabel = new JLabel("Check", SwingConstants.CENTER);
		checkcollabel.setFont(new Font("Apple", Font.BOLD, 16));
		checkcollabel.setForeground(Color.blue);
		checkLabel = new JLabel("  Please input no. of RCM:", SwingConstants.CENTER);
		checkLabel.setFont(new Font("Apple", Font.BOLD, 14));
		statusCheckButton = new JButton("Check Status");
		activateButton = new JButton("Activate Machine");
		openMachineButton = new JButton("Open Machine");
		moneyCheckButton = new JButton("Check Current Money");
		capacityCheckButton = new JButton("Check Current Capacity");
		emptyButton = new JButton("Empty the Machine");
		emptiedTimeButton = new JButton("Check Last Emptied Time");
		usageButton = new JButton("Show Usage Statistics");

		check.add(checkcollabel);
		check.add(checkLabel);
		check.add(numField);
		check.add(openMachineButton);
		check.add(activateButton);
		check.add(statusCheckButton);
		check.add(moneyCheckButton); 
		check.add(capacityCheckButton);
		check.add(emptyButton);
		check.add(emptiedTimeButton);
		check.add(usageButton);

		
		ActionListener logoutAL = new Logout(this);
		logoutButt.addActionListener(logoutAL);
		
		ActionListener addActionListener = new AddNewMachineActionListener(machineField, locationList, idList, priceMap, listOfMachine, setStatus, setMoney, setCapacity);
		createButton.addActionListener(addActionListener);

		AddItemActionListener addItemActionListener = new AddItemActionListener(typeField, priceField, priceMap, listOfMachine);
		addItemButton.addActionListener(addItemActionListener);

		ChangeItemActionListener changeItemActionListener = new ChangeItemActionListener(oldtypeField, newtypeField, priceMap, listOfMachine);
		changeItemButton.addActionListener(changeItemActionListener);
		
		//Template Method
		MachineActionListener activateActionListener = new ActivateActionListener(numField, listOfMachine);
		activateButton.addActionListener(activateActionListener);
		MachineActionListener openMachineActionListener =  new OpenMachineActionListener(numField, listOfMachine);
		openMachineButton.addActionListener(openMachineActionListener);
		MachineActionListener emptyActionListener = new EmptyActionListener(numField, listOfMachine);
		emptyButton.addActionListener(emptyActionListener);	
	
		//Strategy Method
		CheckContext context = new CheckContext();
		context.setCheckStartegy(new CheckStatus(machineField, numField, listOfMachine));
		context.executeCheck(statusCheckButton);
		
		context.setCheckStartegy(new CheckMoney(machineField, numField, listOfMachine));
		context.executeCheck(moneyCheckButton);
		
		context.setCheckStartegy(new CheckCapacity(machineField, numField, listOfMachine));
		context.executeCheck(capacityCheckButton);
		
		context.setCheckStartegy(new CheckEmptyTime(machineField, numField, listOfMachine));
		context.executeCheck(emptiedTimeButton);
		
		context.setCheckStartegy(new CheckUsage(machineField, numField, listOfMachine));
		context.executeCheck(usageButton);
		
		String line = "\n\t List of Machines:\n\n";
		for (RecycleMachine machine : listOfMachine) {
			line = line + "\tRecycle Machine 0"+ machine.getMachineNum() + "  Location: " + machine.getLocation() + "  Id: "+ " " + machine.getId() +" \n";
		}
		machineField.setText(line);

		frame = new JFrame(" EcoRecycle System ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(head, BorderLayout.PAGE_START);
		frame.add(buttList, BorderLayout.LINE_START);
		frame.add(check, BorderLayout.CENTER);
		frame.add(text, BorderLayout.LINE_END);
		
		frame.pack();
		frame.setSize(1100,700);
		frame.setVisible(true);
	}
}