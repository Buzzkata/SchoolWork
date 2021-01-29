//Bozhidar Stoyanov, 0353616
//Solution to the H2O problem using semaphores.
//Showcases the basics of threads.
package nachos.threads;
import nachos.machine.*;
import java.util.concurrent.Semaphore;
 
public class ReactWater{
	public int numHydrogen;
	private Semaphore mutex;  //binary semaphore acts as a lock
	private Semaphore pairOfHydrogen;
	private Semaphore oxygen;
	
	public ReactWater(){
		numHydrogen = 0;
		mutex = new Semaphore(1);
		pairOfHydrogen = new Semaphore(0);
		oxygen = new Semaphore(0);
	}
	
	public void hReady(){
		try{
			mutex.acquire(); //lock the method using mutex to prevent data corruption between threads. 
			
			numHydrogen++;
			if((numHydrogen % 2)==0){
				pairOfHydrogen.release(); //signal the hydrogen pair semaphore.
				
			}
			oxygen.acquire(); //P()
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Hydrogen atom is made.");
		mutex.release(); //V()
		
	}
	
	public void oReady(){
		try{
		pairOfHydrogen.acquire(); //if oReady thread arrives first the value will be 0 thus its blocked at this semaphore wait.(needs 2 hydrogens to proceed).
		makeWater();
		oxygen.release(); 
		oxygen.release();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void makeWater(){
		System.out.println("We have water!"); 
		
	}
	
	public void testReact(){
		final ReactWater water = new ReactWater();
		
		class Hydrogen implements Runnable{
			public void run(){
				System.out.println("Hydrogen thread running. Number of hydrogens: " + water.numHydrogen);
				water.hReady();
			}
		}
		
		class Oxygen implements Runnable{
			public void run(){
				System.out.println("Oxygen thread running.");
				water.oReady();
			}
		}
		
		
		KThread th1 = new KThread(new Oxygen());
		KThread th2 = new KThread(new Hydrogen());
		KThread th3 = new KThread(new Hydrogen());
		KThread th4 = new KThread(new Hydrogen());
		KThread th5 = new KThread(new Oxygen());
		KThread th6 = new KThread(new Hydrogen());
		KThread th7 = new KThread(new Hydrogen());
		KThread th8 = new KThread(new Hydrogen());
		KThread th9 = new KThread(new Oxygen());
		KThread th10 = new KThread(new Hydrogen());
		KThread th11 = new KThread(new Hydrogen());
		KThread th12 = new KThread(new Oxygen());
		
		try{
		th2.fork();
		th1.fork();
		th3.fork();
		th4.fork();
		th5.fork();
		th6.fork();
		th7.fork();
		th8.fork();
		th9.fork();
		th10.fork();
		th11.fork();
		th12.fork();
		
		
		th2.join();  
		th1.join();
		th3.join();
		th4.join();
		th5.join();
		th6.join();
		th7.join();
		th8.join();
		th9.join();
		th10.join();
		th11.join();
		th12.join();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	} 
}