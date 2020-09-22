
public class PassByValueReference {

	public static void main(String[] args) {
		int[] SourceArray = {2,3,1,5,10};
		int[] TargetArray = {3,4,5,6,7,8,9,10};
		//int[] targetArray = SourceArray; // shallow copy. just copy starting address
		System.out.println("[For each loop]");
		for(int e:SourceArray) {
			System.out.print(e+" ");
		}
		System.out.println();
		System.out.println("[arraycopy]");
		System.arraycopy(SourceArray, 0, TargetArray, 0, SourceArray.length);
		for(int e:TargetArray) {
			System.out.print(e+" ");
		}
		
		int x = 1;
		int[] y = new int[1];
		
		System.out.println("x: "+x+", y: "+y[0]);
		
		m(x,y);
		System.out.println("x: "+x+", y: "+y[0]);	
	}

	private static void m(int number, int[] numbers) {
		number =1000;
		numbers[0]=5555;
	}
}
