import java.util.Scanner;

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
		
		char letter2 = '\u0041';
		System.out.println("letter2: "+letter2);
		
		letter2 = (char) 0XAB0041;
		System.out.println("letter2: "+letter2);
		
		byte b =1;
		System.out.println("b: "+b);
		
		b='a';
		System.out.println("b: "+b);
		
		b=-1;
		System.out.println("b: "+b);
		
		int i = (int) 0.444;
		double j =1;
		System.out.println("i: "+i);
		System.out.println("j: "+j);
		
		char ch = 'a';
		
		if(ch>='A' && ch<='Z')
			System.out.println(ch + " is uppercase letter");
		else if(ch>='a'&&ch<='z')
			System.out.println(ch + " is an lowercase letter");
		System.out.println("ch: "+Character.isLetter(ch));
		System.out.println("ch: "+Character.toUpperCase(ch));
		
		String message = "Welcom to Java";
		System.out.println("message: "+message);
		System.out.println("ch: "+message.charAt(0));
		//message.charAt(0)='Z'; the left side assignment must be variable
		//it's constant. string is all constant 
//		message = message.toUpperCase();
		System.out.println("message: "+message);
		//char c1[10] = "~~df"; changeable,
		//char *c2 ="15gg"; not changeable,
		//char 는 기본형
		//String, char* is new.
		//java has 3 types of string. String, StringBuilder, StringBuffer
		//next class
		System.out.println("message: "+message.length());
		System.out.println("trim: "+"\t Good Night \n".trim());
		/*Scanner myInput = new Scanner(System.in);
		System.out.println("Enter three words separated by spaces: ");
		String s1 = myInput.next();
		String s2 = myInput.next();
		String s3 = myInput.next();
		System.out.println("s1+s2+s3: "+s1+" "+s2+" "+s3);
		*/
		String message2 = "Welcome to Java";
		System.out.println("Compare: "+ message.compareTo(message2));
		System.out.println("Compare: "+message.equals(message2));
		if(message == message2) //actually it doesn't compare with contains, it compares address
			System.out.println("Samge Object");
		else
			System.out.println("Different Object");
		String partialMessage = message.substring(0,11)+"Java";
		System.out.println("message: "+partialMessage);
		if(message == partialMessage) //actually it doesn't compare with contains, it compares address
			System.out.println("Samge Object");
		else
			System.out.println("Different Object");
		int intValue = Integer.parseInt("123");
		Double doubleValue = Double.parseDouble("123.45");
		intValue +=100;
		doubleValue +=100;
		System.out.println("intValue: "+intValue);
		System.out.println("intValue: "+doubleValue);
		String s = 10+"";//10 changed to string
		
	}
}
