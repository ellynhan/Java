package inheritanceTest;

public class TestCircle {

	public static void main(String[] args) {
		CircleFromSimpleGeometricObject circle = new CircleFromSimpleGeometricObject(1);
		System.out.println("Circle: "+ circle);
		System.out.println("Color: "+circle.getColor());
	}

}
