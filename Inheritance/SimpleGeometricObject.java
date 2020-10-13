package inheritanceTest;

public class SimpleGeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

	//constructor
	public SimpleGeometricObject() {
		super();
		dateCreated = new java.util.Date();
		
	}
	
	//constructor overloading
	public SimpleGeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color=color;
		this.filled = filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
//	public String toString() {
//		return "haha";
//	}
	
}
