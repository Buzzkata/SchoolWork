import java.util.Scanner;

public class TemperatureTester{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.println("PLease enter initial values:");
		double C1 = kb.nextDouble();
		double C2 = kb.nextDouble();
		
		TemperatureC temp = new TemperatureC(C1);
		TemperatureC temp2 = new TemperatureC(C2);
		System.out.println("CUrrent temp for celsius is: " + temp.getC());
		System.out.println("CUrrent temp for farenheit is: " + temp.getF());
		System.out.println("CUrrent temp for Kelvin is: " + temp.getK());
		
		System.out.println("-------------------------------------------");
		
		System.out.println("CUrrent temp for celsius is: " + temp2.getC());
		System.out.println("CUrrent temp for farenheit is: " + temp2.getF());
		System.out.println("CUrrent temp for Kelvin is: " + temp2.getK());
		System.out.println();
		System.out.println("Please enter a new set of temperatures:");
		double NEW_C1 = kb.nextDouble();
		double NEW_C2 = kb.nextDouble();
		
		temp.setC(NEW_C1);
		temp2.setC(NEW_C2);
		
		System.out.println("CUrrent temp for celsius is: " + temp.getC());
		System.out.println("CUrrent temp for farenheit is: " + temp.getF());
		System.out.println("CUrrent temp for Kelvin is: " + temp.getK());
		
		System.out.println("-------------------------------------------");
		
		System.out.println("CUrrent temp for celsius is: " + temp2.getC());
		System.out.println("CUrrent temp for farenheit is: " + temp2.getF());
		System.out.println("CUrrent temp for Kelvin is: " + temp2.getK());
		
		
	}
	
	
}