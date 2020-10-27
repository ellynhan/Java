
public class ComparbleTest {

	public static void main(String[] args) {
		System.out.println(new Integer(3).compareTo(new Integer(5)));
		System.out.println("ABC".compareTo("ABE"));
		System.out.println("ABC".compareTo("BBE"));
		System.out.println(new Rectangle(1.0,2.0).compareTo(new Rectangle(5.0,5.0)));
	}

}

class Rectangle implements Comparable<Rectangle>{
	double width, height;
	Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return width*height;
	}
	
	@Override
	public int compareTo(Rectangle o) {
		if(getArea()>o.getArea())
			return 1;
		else if(getArea() < o.getArea())
			return -1;
		else 
			return 0;
		
	}
	
	@Override
	public String toString() {
		return super.toString()+"Area: "+getArea();
	}
	
}
