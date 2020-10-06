
public class TestSimpleCircle {

	static class myInnerClass{
		
	}
	
	public static void main(String[] args) {

		SimpleCircle c1 = new SimpleCircle();
		SimpleCircle c2 = new SimpleCircle();
		
		c1.radius = 10;
		System.out.println("c1 area: "+c1.getArea());
		
		c2.radius = 20;
		System.out.println("c1 area: "+c2.getArea());
		
		c1 = c2;
		System.out.println("c1 radius: "+c1.radius);
		System.out.println("c1 area: "+c1.getArea());
		
		System.out.println("Area: "+new SimpleCircle(5).getArea());
		
		myInnerClass number = new myInnerClass();
		Child mySon = new Child();
		mySon.whoAmI();
		
//		Person P = new Person() {
//			String name = "Tom";
//			@override
//			void whoAmI() {
//				System.out.println("I am a child2!!");
//			}
//		}
//		P.whoAmI();
	}

}

class SimpleCircle{
	// member variable
	// methods
	// constructor
	// Overriding
	// OverLoading
	// Polymorphism
	// single inheritance
	// interface
	// Abstract class
	// these are what we gonna learn ..
	
	
	
	
	//construct
	double radius;
	
	//default construct
	SimpleCircle(){
		radius =1;
	}
	
	//overloading
	SimpleCircle(double newRadius){
		radius = newRadius;
		
	}
	
	double getArea() {
		double area;
		area = 3.14*radius*radius;
		return area;
	}
}
