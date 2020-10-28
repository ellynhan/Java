package hw4;

public class GroceryItem {
	protected String name;
	protected double price;
	protected int count;
	
	//constructor
	GroceryItem(String name, double price, int count) {
		this.name=name;
		this.price=price;
		this.count=count;
	}
	
	//toString 
	@Override
	public String toString() {
		return this.name+"\t\t"+this.price+"\t\t"+this.count+"\t\t"+this.amount();
	}
	
	public void setName(String newName) {
		name=newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(double newPrice) {
		price=newPrice;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setCount(int newCount) {
		count = newCount;
	}
	
	public int getCount() {
		return count;
	}
	
	public double amount() {
		return count*price;
	}
}
