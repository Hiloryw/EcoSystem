import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RecycleMachineView  extends View {

	JFrame frame;
	JTextArea detailField;
	JTextField weightField;
	JLabel reLabel, insertWeight, insertType, label, endInsert;
	JPanel headlist, buttList, insertLine;
	ArrayList<JButton> insertButtList;
	JButton start, insert, computeButton, cashButton, couponButton, close;
	
	RecycleMachine machine;
	HashMap<String, Double> priceMap;
	String location;
	String id;
	
	public void setMachine(RecycleMachine machine) {
		this.machine = machine;
	}
	
	public void setPriceMap(HashMap<String, Double> priceMap) {
		this.priceMap = priceMap;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void update(RecycleMachine machine, HashMap<String, Double> priceMap) {
		RecycleMachineView view = machine.getView();
		view = getView(machine, priceMap, machine.getLocation(), machine.getId());
		machine.setView(view);
	}
	
	@Override
	public RecycleMachineView getView(RecycleMachine machine, HashMap<String, Double> priceMap, String location, String id) {
		
		this.machine = machine;
		this.priceMap = priceMap;
		this.location = location;
		this.id = id;	
		
		insertButtList = new ArrayList<JButton>();
		for(String key : priceMap.keySet()) {
			JButton insertButt = new JButton(key);
			insertButt.setEnabled(false);
			insertButtList.add(insertButt);
		}
		headlist = new JPanel();
		headlist.setBackground(new Color(255,255,224));
		label = new JLabel(" Recycle Machine-" + location +"-"+id, SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		close = new JButton("Close Machine");
		
		reLabel = new JLabel("  Start recycling item one by one！");
		weightField = new JTextField(5);
		insert =  new JButton("< Recycle Now >");
		insert.setForeground(Color.BLUE);
		insert.setEnabled(false);
		
		detailField = new JTextArea(40, 50); 
		endInsert = new JLabel("	Want to end insertion?");
		computeButton = new JButton(" Yes! End it!");
		computeButton.setEnabled(false);
		cashButton = new JButton("Get Cash");
		cashButton.setForeground(Color.RED);
		cashButton.setEnabled(false);
		couponButton = new JButton("Get Coupon");
		couponButton.setForeground(Color.GREEN);
		couponButton.setEnabled(false);
		close = new JButton("Close Machine");
		
		
		buttList = new JPanel(new GridLayout(0, 1));
		buttList.setBackground(new Color(173, 216, 230));
		start = new JButton("START");
		insertWeight = new JLabel("   Input the weight of item: ");
		insertType = new JLabel("   Choose the type of item: ");
		buttList.add(reLabel);
		buttList.add(start);
		buttList.add(insertWeight);
		buttList.add(weightField); 
		buttList.add(insertType);

		insertLine = new JPanel();
		insertLine.add(detailField);
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		int i = 0;
		for (String key : priceMap.keySet()) {
			Item item = Item.getItem(key, priceMap.get(key));
			itemList.add(item);
			ActionListener actionListener = new ButtActionListener(insertButtList.get(i), insert, machine, weightField, item);
			insertButtList.get(i).addActionListener(actionListener);
			i += 1;
		}

		for(JButton butt : insertButtList) {
			buttList.add(butt);
		}

		buttList.add(insert);
		buttList.add(endInsert);
		buttList.add(computeButton);
		buttList.add(cashButton);
		buttList.add(couponButton); 
		
		ActionListener startAction = new StartActionListener(insertButtList, insert, computeButton, cashButton, couponButton, detailField, itemList);
		start.addActionListener(startAction);

		ActionListener insertAction = new InsertActionListener(insertButtList, computeButton, machine, detailField, itemList);
		insert.addActionListener(insertAction);

		ComputeActionListener compu = new ComputeActionListener(insertButtList, insert, computeButton, cashButton, couponButton, machine, itemList, detailField);
		computeButton.addActionListener(compu);
		
		ActionListener closeAction = new CloseMachine(machine);
		close.addActionListener(closeAction);
		
		headlist.add(label);
		headlist.add(close);
		
		// Template Method
		GetMoneyActionListener cash = new CashActionListener(machine, itemList);
		cashButton.addActionListener(cash);
		GetMoneyActionListener coupon = new CouponActionListener(machine, itemList);
		couponButton.addActionListener(coupon);

		frame = new JFrame(" EcoRecycyle System ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(headlist, BorderLayout.PAGE_START);
		frame.add(buttList, BorderLayout.LINE_START);
		frame.add(insertLine, BorderLayout.CENTER);
		
		frame.pack();
		frame.setSize(800,600);
		frame.setVisible(false);
		return this;
	}
}

