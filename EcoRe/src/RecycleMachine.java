import java.util.*; 

public class RecycleMachine extends Machine{ 
 	
	private HashMap<String, Double> priceMap;
	private int machineNum;
	private String location;
	private String id;
	private boolean status;
	
	private RecycleMachineView view;
	double capacity;
	double leftCapacity;
	double usedCapacity;
	double onceWeight;
	double monthlyWeight;
	double money;
	double leftMoney;
	double totalIssuedMoney;
	double monthlyMoney;
	int itemNum;
	int emptyNum;
	String emptyTime;
	

	public void setMachineNum(int machineNum){
		this.machineNum = machineNum;
	}

	public int getMachineNum(){
		return machineNum;
	}

	public void setItemNum(int itemNum){
		this.itemNum = itemNum;
	}

	public int getItemNum(){
		return itemNum;
	}
	
	public void setEmptyNum(int emptyNum){
		this.emptyNum = emptyNum;
	}

	public int getEmptyNum(){
		return emptyNum;
	}
	
	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
	
	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean getStatus(){
		return status;
	}

	public void setLeftCapacity(double leftCapacity){
		this.leftCapacity = leftCapacity;
	}

	public double getLeftCapacity(){
		return leftCapacity;
	}
	
	public void setUsedCapacity(double usedCapacity){
		this.usedCapacity = usedCapacity;
	}

	public double getUsedCapacity(){
		return usedCapacity;
	}
	
	public void setOnceWeight(double onceWeight){
		this.onceWeight = onceWeight;
	}

	public double getOnceWeight(){
		return onceWeight;
	}
	public void setMonthlyWeight(double monthlyWeight){
		this.monthlyWeight = monthlyWeight;
	}

	public double getMonthlyWeight(){
		return monthlyWeight;
	}

	public void setLeftMoney(double leftMoney){
		this.leftMoney = leftMoney;
	}

	public double getLeftMoney(){
		return leftMoney;
	}
	
	public void setMonthlyMoney(double monthlyMoney){
		this.monthlyMoney = monthlyMoney;
	}

	public double getMonthlyMoney(){
		return monthlyMoney;
	}
	
	public void setTotalMoney(double totalIssuedMoney){
		this.totalIssuedMoney = totalIssuedMoney;
	}

	public double getTotalMoney(){
		return totalIssuedMoney;
	}
	
	public void setPriceMap(HashMap<String, Double> priceMap) {
		this.priceMap = priceMap;
	}

	public HashMap<String, Double> getPriceMap() {
		return priceMap;
	}

	public void setEmptyTime(String emptyTime) {
		this.emptyTime = emptyTime;
	}
	
	public String getEmptyTime() {
		return emptyTime;
	}
	
	public void setView(RecycleMachineView view) {
		this.view = view;
	}
	
	public RecycleMachineView getView() {
		return view;
	}
	
	@Override
	public RecycleMachine getMachine(HashMap<String, Double> priceMap, String location, String id, boolean status, double money, double capacity) {	
		
		this.priceMap = priceMap;
		this.location = location;
		this.id = id;
		this.status = status;
		this.money = money;
		this.capacity = capacity;
		
		leftMoney = money;
		leftCapacity = capacity;
		usedCapacity = capacity - leftCapacity;
		monthlyWeight += usedCapacity;
		totalIssuedMoney = 0.0;
		monthlyMoney += totalIssuedMoney;

		return this;
	}
	
}



