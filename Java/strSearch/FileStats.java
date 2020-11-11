//Bozhidar Stoyanoav, 0353616
//Program: FileStats
//A program which counts the number of occurences of a given word in a file.
package Question2;
import java.util.*;
import java.io.*;

public class FileStats {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter input file name: ");
		String fileInput = kb.next();
		
		File file = new File(fileInput);
		Scanner in = new Scanner(file);
		
		int words = 0;
		int lines = 0;
		int chars = 0;
		int occ = 0;
		System.out.println("Enter a string to search for: ");
		String wordSearch = kb.next();
		
		while(in.hasNextLine()){
			lines++;
			String line = in.nextLine();
			occ += wordCount(line,wordSearch);
			chars += line.length();
			words += new StringTokenizer(line, " ,;:.").countTokens();
		}
		
		System.out.println(lines + " lines");
		System.out.println(words + " words");
		System.out.println(chars + " chars");
		System.out.println("the word " + wordSearch +" appears " + occ + " many times");
		
		in.close();
		kb.close();
	}
	public static int wordCount(String text, String w){
		int c = 0;
		while(text.contains(w)){
			c++;
			text = text.substring(text.indexOf(w) + w.length());
		}
		return c;
	}
	
	
}
