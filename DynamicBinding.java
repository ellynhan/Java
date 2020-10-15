
public class DynamicBindingDemo {

	public static void main(String[] args) {
		m(new GraduateStudent());
		m(new Student());
		m(new Person());
		m(new Object());
		
		System.out.println("Object o");
		Object o = new Student();
		m(o);
		Object o2 = new GraduateStudent();
		m(o2);
		//Student b = o //error object cannot convert to student
		Student b = (Student)o; //explicit type casting possible cause o is related with Student()
		m(b);
		Object o3 = new Object();
		//Student b2 = (Student)o3; //error Object cannot be cast to class Student
		//m(b2);
		
	}
	public static void m(Object o) {
		System.out.println(o.toString());
	}

}
class GraduateStudent extends Student{
	@Override
	public String toString() {
		return "GraduateStudent";
	}

}

class Student extends Person{
	@Override
	public String toString() {
		return "Student";
	}
}


class Person extends Object{
	@Override
	public String toString() {
		return "Person";
	}
}
