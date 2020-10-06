
public class Child extends Person{
	//member method
	@Override
	//it's not required to type @Override, but it's highly recommended 
	void whoAmI() {
		System.out.println("I am a child!!");
	}
}
