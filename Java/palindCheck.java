//Bozhidar Stoyanov 0353616
//Program to test if a string is a palindrome

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class palindCheck {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in); // Keyboard input
		String line; // One input line
		do {
			System.out.print("Your expression (or return to end): ");
			line = stdin.nextLine();
			if (isWordPalindrome(line)){
				System.out.println("That is a palindrome.");
			}
				
			else{
				System.out.println("That is not a palindrome.");
			}
		
		} while (line.length() != 0);
		stdin.close();
	}
	
	/**
	* Determine whether a string if the letters in the string read the same forward and backward
	* upper and lower-case letters,punctuation ignored
	* @param input the string to check
	* @return true if and only if the input string is a Palindrome.
	**/
	public static boolean isWordPalindrome (String input) {
	boolean plaindrmFlag = true;//Declaring boolean flag, if input line is Palindrom then set as true, otherwise false
	//Declaring Linked List to store each word in line in forward order
		LinkedList<String> forwardOrderList = new LinkedList<String> ();
		//Declaring Linked List to store each word in line in backward order
		LinkedList<String> backwardOrderList = new LinkedList<String> ();
		
		String[] wordArray = input.split("\\s+");// Getting array of word from the line, \\s+ regular expression used to split the word
		
		//Iterating each word in the array from the start of the line to end (forward order)
		for (int i=0;i<wordArray.length;i++) {
			forwardOrderList.add(wordArray[i].replaceAll("[\\W]", ""));//Adding each word without any punctuation,[\\W] regular expression used to replace punctuation
		}
		
		//Iterating each word in the array from the start of the line to end (backward order)
		for (int i=wordArray.length-1;i>=0;i--) {
			backwardOrderList.add(wordArray[i].replaceAll("[\\W]", ""));//Adding each word without any punctuation,[\\W] regular expression used to replace punctuation
		}
		
		//Iterating loop till the number words present in the array
		for (int i=0;i<wordArray.length;i++) {
	   
			//checking if both the list have same word ignoring case, if true then continue, else setting the plaindrmFlag as false and terminating the loop
			if (!forwardOrderList.get(i).equalsIgnoreCase(backwardOrderList.get(i))) {
				plaindrmFlag = false;//setting the plaindrmFlag as false
				break;//terminating the loop
			}
		}
		//returning the flag
		return plaindrmFlag;
	}
}
