package hw4;

public class MYFRIDGE {
	
	public static void main(String[] args) {
		double total;
		
		GroceryItemWithStore item1 = new GroceryItemWithStore("bananas",0.99,22,"Costco");
		GroceryItemWithStore item2 = new GroceryItemWithStore("oranges",2.99,4,"Times");
		GroceryItemWithStore item3 = new GroceryItemWithStore("garlic",3.99,8,"Safeway");
		GroceryItemWithStore item4 = new GroceryItemWithStore("grapes",9.99,2,"KTA Super Stores");
		GroceryItemWithStore item5 = new GroceryItemWithStore("papayas",4.99,6,"farmer's market");
		
		total = item1.amount()+item2.amount()+item3.amount()+item4.amount()+item5.amount();
		
		System.out.println("name\t\tprice\t\tcount\t\tamount\t\tstore\n");
		System.out.println(item1.toString()+"\n");
		System.out.println(item2.toString()+"\n");
		System.out.println(item3.toString()+"\n");
		System.out.println(item4.toString()+"\n");
		System.out.println(item5.toString()+"\n");
		System.out.println("\t\t\t\t\t\tTOTAL: $"+String.format("%.2f",total));
	}
}
