import java.util.Scanner; 
//Bozhidar Stoyanov
//0353616
//Question 2

public class stats { //Public class named stats.
	public static void main(String [] args) { //Main method.
		Scanner in = new Scanner(System.in); //Scanner initialization.
		System.out.println("Enter a double number (negative to quit)): "); //Print command.
		double user_input = in.nextDouble(); //Store the number from the user in a double called user_input.
		
		double product = 1; //Set up a double called product to equal 1. 
		double sum = 0; //Initialize double called sum which is ised to calculate the sum of all entered values
		int count = 0; //Initialize the count in order to keep count of entries and if the user entered a negative number from the start
		double average, range, maximum, minimum; //Set up the doubles for average, range, maximum and minimum.
		maximum = user_input; //Assign the user entered value to both maximum and minimum.
		minimum = user_input;
		
		
		
		while(user_input > 0){ //While loop executes as long as the user input is bigger than 0.
			product*=user_input; //Multiply every new double entered by the user.
			sum += user_input; //Add the sum of every input entered.
			count++; //Increase the count by 1 everytime the while loop goes through (everytime the condition of user input>0 is met).
			if(user_input > maximum){ //compare the input with the maximum one and assign maximum if its bigger.
				maximum = user_input;
			}
			else if(user_input<minimum){ //compare with the minimum and assign minimum if its smaller.
				minimum = user_input;
			}
			user_input=in.nextDouble(); //Prompting user to reenter data. If its bigger than 0 it will keep going back in the loop.
		}
		if(count == 0){ //If count is zero it means the while loop never went through, so the user entered a negative number from the start.
			System.out.println("You entered an initial negative number."); //Print error message.
		}
		
		else{ //If count is not zero it means that the while loop went through.
			average = ((double)sum)/count; //Calculate average.
			range = maximum-minimum; // Calculate range.
			System.out.println("Count: " + count); //Print the count, maximum, minimum, sum, product, average and range.
			System.out.println("Max: " + maximum);
			System.out.println("Min: " + minimum);
			System.out.println("Sum: " + sum);
			System.out.println("Product: " + product);
			System.out.println("Average: "+ average);
			System.out.println("Range: " + range);
			System.out.println("Program complete");
			
			
		}
						
	}

}