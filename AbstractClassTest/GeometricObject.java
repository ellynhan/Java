
public abstract class GeometricObject {
	private String color = "white";
	
	public GeometricObject() {
		
	}
	public String getColor() {
		return color;
	}
	
	public abstract double getArea();
	public abstract double getWidth();
}
