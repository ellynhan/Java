
public class PassByValueReference {

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 2;
		System.out.println("n1: "+num1+" n2: "+num2);
		swap(num1,num2);
		System.out.println("num1: "+num1+" num2: "+num2);//not changed
		// This one C-style array declaration
		//double myList[] = new double[10];
		
		double[] myList = new double[10];
		myList[0] = 5.6;
		System.out.println("myList[0]: "+myList[0]);
		
		int[] SourceArray = {2,3,1,5,10};
		//int[] targetArray = SourceArray; // shallow copy. just copy starting address
		int[] targetArray = new int[SourceArray.length];
		
		for(int i=0; i<SourceArray.length; i++) {
			System.out.print(SourceArray[i]+" ");
			targetArray[i]=SourceArray[i];
			//deep copy와 shallow copy 차이 알아 볼 것.
		}
		System.out.println();
		for(int i=0; i<targetArray.length; i++) {
			System.out.print(targetArray[i]+" ");
		}
	}
	public static void swap(int n1, int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
		//System.out.println("n1: "+n1+" n2: "+n2);
	}
	public static void swap(double n1, double n2) {
		double temp = n1;
		n1 = n2;
		n2 = temp;
		//System.out.println("n1: "+n1+" n2: "+n2);
	}

}
