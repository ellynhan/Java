
public class TestEidible {

	public static void main(String[] args) {
		Object[] objects = {new Tiger(), new Chicken(), new Apple(), new Orange()};
	
	
	for(Object o : objects) {
		if(o instanceof Edible)
			System.out.println(((Edible) o).howtoEat());
		if(o instanceof Animal)
			System.out.println(((Animal) o).sound());
	}
  }

}



abstract class Animal {
	public abstract String sound();
}

class Chicken extends Animal implements Edible{

	@Override
	public String sound() {
		return "Chicken: cock-a-doodle-doo";
	}

	@Override
	public String howtoEat() {
		return "Chicken: Fry it!!";
	}
	
}

class Tiger extends Animal{

	@Override
	public String sound() {
		// TODO Auto-generated method stub
		return "Tiger: RROOAAR";
	}
	
}

abstract class Fruit implements Edible{
	
}

class Apple extends Fruit{

	@Override
	public String howtoEat() {
		// TODO Auto-generated method stub
		return "Apple: Make apple cider";
	}
}

class Orange extends Fruit{

	@Override
	public String howtoEat() {
		// TODO Auto-generated method stub
		return "Orange: Make orange juice";
	}
	
}
