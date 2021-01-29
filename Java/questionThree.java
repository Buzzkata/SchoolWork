import java.util.Scanner;
//Bozhidar Stoyanov
//0353616
//Question 3


public class questionThree {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in); //Creating a scanner to prompt the user for value.
		
		boolean valid = false; //Initialize a boolean with original value false.
		
		while(!valid){ //Set up a while loop prompting the user to keep entering data while valid is false.
			System.out.println("Enter a number between 1 and 1o"); //Prints the command.
			int input = in.nextInt(); //Stores the user input in the integer called "input".
			
			if(0<input && input<=10){ //This executes once the condition is met, meaning once the user enters a number between 1 and 10.
				valid = true; //Change the boolean to true since our condition is met. Now the while loop will not run anymore.
				
				for(int i = 1;i<=input;i++){ //Outer loop for the nested for loops needed to form the math table. Will keep executing until it reaches the user value.
			
					for(int j = 1; j<=input;j++){ //Inner loop. 
			
						System.out.print((i*j) + "\t"); //Prints out on one row the product of the outer loop times the inner loop. 
			
					}
					System.out.println(); //Here a new line is created and int i takes the next number and is again multiplied by the inner loop until it reaches the user value.
		
				}
			}
		}
		
		
		
	}
	
}