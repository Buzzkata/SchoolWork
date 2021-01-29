import java.util.Random;
import java.util.Scanner;

public class arrayOperations{
	public static void initialize(int[][] a, int min, int max){
		Random rand = new Random();
		for(int i = 0;i<a.length;i++){
			for(int b = 0;b<a[0].length;b++){
				int n = rand.nextInt(max) + min;
				a[i][b] = n;
			}
		}
		
	}
	public static int[][] sum(int[][] a, int[][] b){
	    for(int c=0;c<a.length;c++){
	        for(int z=0;z<a[0].length;z++){
	            b[c][z] = a[c][z] + b[c][z];
	            
	        }
	        
	    }
	    return b;
	    
	    
	}
	public static void reverse(int[][] a){
	    if(a.length % 2 == 0){ //if the number of rows is even
	        for(int r=0;r<a.length/2;r++){
	            for(int e=0;e<a[0].length;e++){
	                int temp = a[a.length- r - 1][a[0].length - e -1];
	                int temp2 = a[r][e];
	                a[r][e] = temp;
	                a[a.length- r - 1][a[0].length - e - 1] = temp2;
	            
	            }
	        }
	    }
	    else{  //if the number of rows is odd
    	    for(int y=0;y<=a.length/2;y++){
    	        for(int x=0;x<a[0].length;x++){
    	            int temp = a[a.length- y - 1][a[0].length - x -1];
    	            int temp2 = a[y][x];
    	            a[y][x] = temp;
    	            a[a.length- y - 1][a[0].length - x -1] = temp2;
    	        }
    	    }
    	    for(int w = 0; w < a[0].length/2;w++){
    	        int t1 = a[a.length/2][w];
    	        int t2 = a[a.length/2][a[0].length - w -1];
    	        a[a.length/2][w] = t2;
    	        a[a.length/2][a[0].length - w -1] = t1;
    	        
    	    }
	    
	    }
	    
	}
	
	public static int[][] copy(int[][] a){
		
		int [][] copyarr = new int[a.length][a[0].length];
		for(int s = 0;s < a.length;s++){
			for(int f = 0;f< a[0].length;f++){
				int temp = a[s][f];
				copyarr[s][f] = temp;
			}
		}
		return copyarr;
	}
	public static void printArray(int[][] a){
		for(int w= 0;w<a.length;w++){
			for(int e = 0;e < a[0].length;e++){
				System.out.printf("% 4d" , a[w][e]);
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of rows: ");
		int rows = sc.nextInt();
		System.out.println("Please enter number of columns: ");
		int columns = sc.nextInt();
		System.out.println();
		
		int[][] array = new int[rows][columns];
		int[][] ar = new int[rows][columns];
		initialize(array, 1, 10);
		initialize(ar, 1, 10);
		printArray(array);
		System.out.println();
		
		printArray(ar);
		System.out.println();
		
		sum(array,ar);
		printArray(ar);
		System.out.println();
		
		reverse(ar);
		printArray(ar);
		System.out.println();
		
		copy(ar);
		printArray(ar);
		
		
		
	
		
	}



}