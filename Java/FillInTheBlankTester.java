package question2;
import java.util.Scanner;

public class FillInTheBlankTester {

	public static void main(String[] args) {
		/**This tester is NOT related to your solution and is just here 
		 * to show you how the FitB class works.
		 */
		
		//create scanner
		Scanner keyb = new Scanner(System.in);
		
		System.out.println("Creating a hard-coded fill-in-the-blank question..." );
		String question = "The airspeed of a(n) _______________ swallow is 11 m/s.";
		String answer = "unlaiden";
		
		FillInTheBlank fitb1 = new FillInTheBlank(question, answer);
		
		System.out.println("\nCreating another..." );
		System.out.print("Enter the question: ");
		question = keyb.nextLine();
		System.out.print("Enter the answer: ");
		answer = keyb.nextLine();
		
		FillInTheBlank fitb2 = new FillInTheBlank(question, answer);

		System.out.println("\nPrinting via toString():");
		System.out.println(fitb1);
		System.out.println(fitb2);
		
		System.out.println("\nPrinting just the questions:");
		System.out.println(fitb1.getQuestion());
		System.out.println(fitb2.getQuestion());
		
		System.out.println("\nPrinting just the answers:");
		System.out.println(fitb1.getAnswer());
		System.out.println(fitb2.getAnswer());
		
		
		
	}

}
