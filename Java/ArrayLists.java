import java.util.ArrayList;
import java.util.Scanner;

//Bozhidar Stoyanov
//0353616
//Arraylists program

public class ArrayLists{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a positive value between 2 and 12 for your array: ");
		int input = in.nextInt();
		while(input < 2 || input > 12){
			System.out.println("Please enter a positive value between 2 and 12 for your array: ");
			input = in.nextInt();
		}
		ArrayList<Integer> arrli = new ArrayList<Integer>(input);
		
		for(int a = 0; a < input; a++){
			System.out.println("Enter a value: ");
			int i = in.nextInt();
			arrli.add(i);
		}
		
		for(int z = 0; z < input; z++){
			System.out.print(arrli.get(z) + ", ");	
		}
		
		System.out.println();
		
		for(int q = (input-1); q >= 0; q--){
			System.out.print(arrli.get(q) + ", ");	
		}
		
		System.out.println();
		
		for(int v = 0; v < input; v++){
			if(arrli.get(v) %2 != 0){
				System.out.print(arrli.get(v) + ", ");
			}
		}
		
		System.out.println();
		
		for(int c = 1; c <= input; c+=2){
			System.out.print(arrli.get(c-1) + ", ");	
		}
		
		System.out.println();
		
		int maximum = arrli.get(0);
		int indx = 1;
		for(int f = 0; f < input; f++){
			if(maximum < arrli.get(f)){
				maximum = arrli.get(f);
				indx = f+1;
			}
			
		}
		
		System.out.println();
		System.out.println("Max value is: " + maximum + " at index: " + indx);
		System.out.println("Enter a value to see if its in the array: ");
		int value = in.nextInt();
		int count = 0;
		for(int b = 0;b < input; b++){
			if(value == arrli.get(b)){
				count++;
			}
		}
		System.out.println("The value " + value + " occurs " + count + " time(s) ");
		
	}

}