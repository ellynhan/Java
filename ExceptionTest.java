
public class ExceptionTest {
	
	static void callDriver() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleeDriver");
		System.out.println("Completed!");
		
	}
	
	static void callException() throws MyException {
		throw new MyException();
		
	}
	
	public static void main(String[] args) {
		try {
			callException();
		} catch (MyException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Terminated!!");
		}
		
		
		
		/*
		try {
			callDriver();
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find oracle.jdbc.driver.OracleDriver!!");
		} finally {
			System.out.println("Terminated");
		}*/
		
		/*
		String[] name = new String[2];
		
		try {
			name[0]= "BTS";
			name[1]= "BlackPink";
			name[2]= "GirlGeneration";
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index 2 out of bounds for name [] length 2");
		} catch(Exception e) {
			System.out.println("Index 2 out of bounds for name [] length 2");
		} finally {
			//default any action (or brhavior)
			System.out.println("Program will stop here!!");
		}
		 */

	}

}

/*
  catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index 2 out of bounds for name [] length 2");
		}
*/
