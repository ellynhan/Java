
public class CastingDemo {

	public static void main(String[] args) {
		Object o1 = new AA();
		Object o2 = new BB();
		Object o3 = o1;
		
		System.out.println(o1);
		displayArea(o1);
		displayArea(o2);
		System.out.println(o1.equals(o2));
		System.out.println(o1.equals(o3));
		
	}
	public static void displayArea(Object o) {
		if(o instanceof AA) {
			System.out.println("AA area: " + ((AA) o ).getArea());
			
		}
		else if(o instanceof BB) {
			System.out.println("BB area: " + ((BB) o ).getArea());
		}
	}

}

class A{
	public boolean equals(Object o) {
		return (this==o);
	}
}

class AA extends A{
	double area = 5.0;
	
	public double getArea() {
		return area;
	}
}

class BB extends A{
	double area =10.0;
	
	public double getArea() {
		return area;
	}
}
