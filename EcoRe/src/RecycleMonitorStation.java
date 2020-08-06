import java.util.*; 

public class RecycleMonitorStation {
	
    public static void main(String args[]) {
    	new Login();
        //new RecycleMonitorStation();  
    }

	HashMap<String, Double> priceMap;
	ArrayList<RecycleMachine> listOfMachine;
	ArrayList<RecycleMachineView> listOfView;
	ArrayList<String> locationList;
	ArrayList<String> idList;
	boolean setStatus;
	double setMoney;
	double setCapacity;
    
    public RecycleMonitorStation() {

		listOfMachine = new ArrayList<RecycleMachine>();
		listOfView= new ArrayList<RecycleMachineView>();
		priceMap = new HashMap<String, Double>();
		priceMap.put("Paper", 0.5);
		priceMap.put("Glass", 1.0);
		priceMap.put("Plastic",0.2);
		priceMap.put("Bottle", 0.5);
		priceMap.put("Iron", 3.0);
		priceMap.put("Aluminum", 1.5);

		locationList = new ArrayList<String>();
		locationList.addAll(Arrays.asList("SunnyVale", "San Jose", "Santa Clara", "Alameda", "San Mateo", "Milpitas", "Campbell", "Cupertino"));

		idList = new ArrayList<String>();
		idList.addAll(Arrays.asList("EcoRe000001", "EcoRe000002", "EcoRe000003", "EcoRe000004", "EcoRe000005", "EcoRe000006", "EcoRe000007",  "EcoRe000008"));

		setStatus = false;
		setMoney = 100.0;
		setCapacity = 50.0;
		
		// Abstract Factory & Factory Method
		RCMFactory rcmFactory = new RCMFactory();
		RecycleMachine reMachine1 = rcmFactory.createMachine().getMachine(priceMap, locationList.get(0), idList.get(0), setStatus, setMoney, setCapacity);
		reMachine1.setMachineNum(1);
		reMachine1.setStatus(true);
		RecycleMachineView view1 = rcmFactory.createView().getView(reMachine1, reMachine1.getPriceMap(), reMachine1.getLocation(), reMachine1.getId());
		reMachine1.setView(view1);
		listOfMachine.add(reMachine1);

		RecycleMachine reMachine2 = rcmFactory.createMachine().getMachine(priceMap, locationList.get(1), idList.get(1), setStatus, setMoney, setCapacity);
		reMachine2.setMachineNum(2);
		reMachine2.setStatus(true);
		RecycleMachineView view2 = rcmFactory.createView().getView(reMachine2, reMachine2.getPriceMap(), reMachine2.getLocation(), reMachine2.getId());
		reMachine2.setView(view2);
		listOfMachine.add(reMachine2);

		new RecycleMonitorStationView(locationList, idList, priceMap, listOfMachine, setStatus, setMoney, setCapacity);
    }
}



