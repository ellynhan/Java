package inheritanceTest;

public class CircleFromSimpleGeometricObject extends SimpleGeometricObject {
	private double radius;
	
	public CircleFromSimpleGeometricObject() {
		
	}
	
	public CircleFromSimpleGeometricObject(double radius) {
		this.radius = radius;
	}
	
	public CircleFromSimpleGeometricObject(double radius, String color, boolean filled) {
		super(color,filled);
		this.radius = radius;
		setFilled(filled);
		setColor(color);
		
	}
	
	
}
