//Bozhidar Stoyanov 0353616
//GUI which takes in a text file and reverses it line by line. It works by storing the string line
//char by char and pushing each char into our LinkedStack. The stack then pops each element into another
//char array which is then added into a string called "result", with each line of the file that is 
//iterated in the while loop. It then creates a file called output file with the inputted text file 
//reversed, in the same directory. The program works with every character/int. It also works
//with files that contain multiple lines of text.

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class LSTester {

    public static void main(String[] args) throws IOException {
		LLStack lStack = new LLStack(); //create a linked stack object
        JFileChooser inFile = new JFileChooser(); //Jfilechooser in order for the user to choose a file
        int jfcUserOption = inFile.showOpenDialog(null);

        //Verify it reads

        String filename = null;

        if (jfcUserOption == JFileChooser.APPROVE_OPTION) {

			File chosenFile = inFile.getSelectedFile();
            filename = chosenFile.getAbsolutePath();
            System.out.println("The file you chose was: " + filename);

        }

        String result = ""; //this is the string which we will store our reversed text file
		BufferedReader reader; //buffer reader so we can keep looping line by line in our text file
		try{
			
			reader = new BufferedReader(new FileReader(filename)); //set the filename path to the reader
			String line = reader.readLine(); //store first line of the input file in a string called line
			while(line != null){ //keep looping until the file is empty
				int size = line.length();  //assign size value of the length of the string
				char[] strToArr = line.toCharArray(); //turn the string to a char arr
				
				
				
				for(int i = 0;i < size;i++){ //for loop to assign the line to a char arr, which is pushed in the stack below
					lStack.push(strToArr[i]); //already reversed, because every char is pushed. They are stacked one over the other. Therefore first pushed value will be the end of the stack
			
				}
				char[] arr = new char[size]; //another char arr in order to assing the values from the stack to it and afterwards add it to our result string
				for(int b = 0;b < size;b++){
					arr[b] = ((char)lStack.pop()); //need to spcify our data type. First poped value is the last one that was pushed in the stack. Like in real life one can only access the top element of the stack
			
			
				}
				result += new StringBuilder(new String(arr) + " \n"); //This is the output string which is written onto our output text file
				
				line = reader.readLine(); //assign the next line in the input file
			}
			reader.close();
			
		}catch(IOException e){ //catch exception if any
			e.printStackTrace();
		}
		
   
        FileWriter fw=new FileWriter("output.txt"); //write out to a file called output.txt

        fw.write(result); //write to it our string result
        System.out.println("the output file is saved in the same directory as the input file:");
        fw.close();
		System.out.println("Here is the value stored in our output file: ");
        System.out.println(result);

    }

}

