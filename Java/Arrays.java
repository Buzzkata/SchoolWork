import java.util.Scanner;

//Bozhidar Stoyanov
//0353616
//Array program

public class Arrays{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number for elements in an array: ");
		int user_in = in.nextInt();
		int index = 1;	
		while(user_in < 2 || user_in > 12){
			System.out.println("Enter a number for elements in an array between 2 and 12: ");
			user_in = in.nextInt();
		}
		int[] arr = new int[user_in];
		
		for(int i = 0;i < arr.length; i++){
			System.out.println("Enter a value:");
			arr[i] = in.nextInt();
			
		}
		
		for(int a = 0; a < arr.length; a++){
			System.out.print(arr[a] + ", ");
			
		}
		
		System.out.println();
		
		for(int s = (user_in-1); s >= 0; s--){
			System.out.print(arr[s] + ", ");
		}
		
		System.out.println();
		for(int r = 0; r < arr.length; r++){
			if(arr[r]%2 != 0){
				System.out.print(arr[r] + ", ");
			}
			
		}
		System.out.println();
		
		for(int k = 1; k <= arr.length; k+=2){
			System.out.print(arr[k-1] + ", ");
			
		}
		System.out.println();
		
		int max = arr[0];
		
		for(int w = 0; w < arr.length; w++){
			if(max < arr[w]){
				max = arr[w];
				index = w+1;
			}
			
		}
		System.out.println("max value is: " + max + " at index: " + index);
		
	}

}