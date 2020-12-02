import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreadDemo {

	public static void main(String[] args) {
		
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		// Submit runnable tasks to the executor
		executor.execute(new PrintChar('a',100));
		executor.execute(new PrintChar('b',100));
		executor.execute(new PrintNum(100));
		
		executor.shutdown();
		
		/*
		//1. create task instance
		//2. make a thread
		//3. start thread
		
		
		Runnable printA = new PrintChar('a',100);
		Runnable printB = new PrintChar('b',100);
		Runnable print100 = new PrintNum(100);
		
		//create threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
		
		thread3.setPriority(Thread.MAX_PRIORITY);
		
		//start threads
		thread1.start();
		thread2.start();
		thread3.start();
		//==>outcome is changeable. 
		//it's race competition.
		*/
	}

}

class PrintChar implements Runnable{
	//Thread body
	private char charToPrint;
	private int times;
	
	//constructor
	public PrintChar(char c, int t) {
		charToPrint = c;
		times = t;
	}
	
	@Override
	public void run() {
		for(int i=0; i<times; i++) {
			System.out.print(charToPrint);
		}
	}
}

class PrintNum implements Runnable{
	private int lastNum;
	
	//Constructor
	public PrintNum(int n) {
		lastNum = n;
	}
	
	@Override
	public void run() {
		/*
		for(int i=0; i<lastNum; i++) {
			System.out.print(" " + i);
//			Thread.yield();//Every time a number is printed, the thread print100 task is yielding to other threads.
			if(i >= 50) {
				try {
					Thread.sleep(1);
				}catch(InterruptedException e){
					e.printStackTrace(); 
				}
			}
		}
		*/
		Thread thread4 = new Thread(new PrintChar('c', 40));
		thread4.start();
		try {
			for(int i=0; i<=lastNum; i++) {
				System.out.print(" " + i);
				if(i == 50) {
					thread4.join();
				}
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
