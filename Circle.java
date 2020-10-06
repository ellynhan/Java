package thisConstructor;

import java.math.BigInteger;

public class Circle {
	
	private double radius;
	
	public Circle(double radius) {
		
		this.radius = radius;
		
	}
	public Circle() {
		//by default you want to set radius to 1.0
		//radius = 1.0; you don't want to set radius to 1 as here
		// You just want to use Circle(1.0) instead of using radius = 1.0;
		// Please use "this" to invoke another constructor
		this(1.0);
	}
	
	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle(1.0);
		
		Double doubleObject = Double.valueOf("12.4");
		Integer integerObjet = Integer.valueOf("12",10); 
		System.out.println(Integer.parseInt("11",2)); // 문자열, 진
		System.out.println(Integer.parseInt("12",8));
		System.out.println(Integer.parseInt("13",10));
		System.out.println(Integer.parseInt("1A",16));
		
		//Integer intObject = new Integer(2);
		Integer intObject = 2;
		System.out.println(intObject);
		Integer[] intArray = {1,2,3};
		System.out.println(intArray[0]+intArray[1]+intArray[2]);
//		Integer a = new Integer("9223372936854775807");
		BigInteger a = new BigInteger("9223372936854775807");
		System.out.println(a);
		
		String message = new String("Welcome to Java");
		String message2 = "Welcome to Java";
		char[] charArray = {'G','o','o','d','B','y','e'};
		String message3 = new String(charArray); //String class provide a constructor public String(char[])
		System.out.println(message3);
		System.out.println("Java is fun".matches("Java.*"));
		System.out.println("Java is fun".matches("Java"));
		System.out.println("440-02-4534".matches("\\d{3}-\\d{2}-\\d{4}")); //digit{length}, \\d = 1 digit
		String s1 = "a+b$#c".replaceAll("[S+#]", "NNN");
		System.out.println(s1);
		
		//String is immutable
		//StringBuilder & StringBuffer is mutable.
	}

}
