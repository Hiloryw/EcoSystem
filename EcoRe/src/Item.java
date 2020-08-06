// Initialize the items' type and price

public final class Item {

	private static Item item;
	private String type;
	private double price = 0.0;
	private double value;
	private double weight = 0.0;
	private int num = 0;
 
	// Singleton pattern
	private Item(String type, double value) {
		this.type = type;
		this.value = value;
	}
	
	public static Item getItem(String type, double value) {
		item = new Item(type, value);
		return item;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setValue(double value){
		this.value = value;
	}

	public double getValue(){
		return value;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	public void setNum(int num){
		this.num = num;
	}

	public int getNum(){
		return num;
	}

}