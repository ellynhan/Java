
public class ElementaryTest {

	public static void main(String[] args) {
		//9.8 java selection class
		
		final double PI = 3.141592;
		System.out.println("Int/Int:" +(3/2));
		System.out.println("Int mod (%) Int" +(3%2));
		System.out.println("Display binary bits: "+0B1111);
		System.out.println("Display Octectss: "+0777);
		System.out.println("Display Hexadecimal: "+0xFFFF);
		
		/*
		 * for example, read card number
		 * 2324 4545 4519 3415
		 * */
		
		long creditCardNumbers = 2324_4545_4519_3415L;
		System.out.println(creditCardNumbers);
		
		System.out.println("Boolean result: " + (2>3));
		System.out.println("Boolean result: " + (2<3));

		double x = 1.0-0.1-0.1-0.1-0.1-0.1;
		System.out.println(x == 0.5);
		System.out.println(x);
		
		final double EPSILON = 1E-15; //14 0 and 1.
		if(Math.abs(x-0.5)<EPSILON) {
			System.out.println(x+"is approximately 0.5");
		}
		
		boolean even;
		int number = 10;
//		if(number%2 == 0)
//			even = true;
//		else
//			even = false;
		even = (number%2==0);
		System.out.println("even: "+even);
		
		//The other advanced technique
		int x1 = 10;
		int y1 = 20;
		y1 = (x1>10) ? 1 : -1;
		System.out.println(y1);
		
		System.out.println(Math.PI);
		System.out.println(Math.E);
		char letter ='A';
		letter = 'A'+1;
		System.out.println("letter: "+letter);
		letter = (char) (letter+'A');
		System.out.println("letter: "+letter);
		int num4 = 'a'+'b';
		System.out.println("num4: "+num4); // ascii code a(97) b(98)
		System.out.println("a ascii value: "+((int)'a'));
		
				
	}
}
