
public class StaticVariableCount {
	static int numberOfObjects = 0;
	StaticVariableCount(){
		numberOfObjects++;
	}
	void DisplayStaticVariable() {
		System.out.println("numberOfObject: "+numberOfObjects);
	}
}
