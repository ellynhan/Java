package hw4;

public class GroceryItemWithStore extends GroceryItem {
	private String store;
	
	GroceryItemWithStore(String name, double price, int count, String store) {
		super(name, price, count);
		this.store=store;
	}

	@Override
	public String toString() {
		return super.toString()+"\t\t"+this.store;
	}
}
