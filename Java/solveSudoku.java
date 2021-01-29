public class solveSudoku{
	public static void main(String[] args){
		int[][] sudoku = {
			{5,3,4,6,7,8,9,1,2},
			{6,7,2,1,9,5,3,4,8},
			{1,9,8,3,4,2,5,6,7},
			{8,5,9,7,6,1,4,2,3},
			{4,2,6,8,5,3,7,9,1},
			{7,1,3,9,2,4,8,5,6},
			{9,6,1,5,3,7,2,8,4},
			{2,8,7,4,1,9,6,3,5},
			{3,4,5,2,8,6,1,7,9},
		
		};
		
		System.out.println("The sudoku is:");
		boolean ans = validate(sudoku);
		System.out.println(ans);
	}
	
	public static boolean validate(int[][] arr){
		
		boolean valid1;
		boolean valid2;
		boolean valid3;
		boolean valid4;
		boolean valid5;
		boolean valid6;
		boolean valid7;
		boolean valid8;
		boolean valid9;
		int countValid = 0;
		
		for(int i =0;i < arr.length;i++){
			valid1 = false;
			valid2 = false;
			valid3 = false;
			valid4 = false;
			valid5 = false;
			valid6 = false;
			valid7 = false;
			valid8 = false;
			valid9 = false;
			
			for(int k = 0;k<arr[i].length;k++){
				if(arr.length != arr[k].length){ //if rows are different than the current column
					return false;
				}
				if(arr[i][k] == 1){
					valid1 = true;
				}
				else if(arr[i][k] == 2){
					valid2 = true;
				}
				else if(arr[i][k] == 3){
					valid3 = true;
				}
				else if(arr[i][k] == 4){
					valid4 = true;
				}
				else if(arr[i][k] == 5){
					valid5 = true;
				}
				else if(arr[i][k] == 6){
					valid6 = true;
				}
				else if(arr[i][k] == 7){
					valid7 = true;
				}
				else if(arr[i][k] == 8){
					valid8 = true;
				}
				else if(arr[i][k] == 9){
					valid9 = true;
				}
				else{
					return false;
				}
			}
			
			if(valid1 && valid2 && valid3 && valid4 && valid5 && valid6 && valid7 && valid8 && valid9){
				countValid++;
			}
			
		}
		
		boolean validr1;
		boolean validr2;
		boolean validr3;
		boolean validr4;
		boolean validr5;
		boolean validr6;
		boolean validr7;
		boolean validr8;
		boolean validr9;
		int countValidRow = 0;
		
		for(int col = 0;col<arr.length;col++){
			validr1 = false;
			validr2 = false;
			validr3 = false;
			validr4 = false;
			validr5 = false;
			validr6 = false;
			validr7 = false;
			validr8 = false;
			validr9 = false;
			
			for(int row = 0;row<arr[col].length;row++){
				if(arr[row][col] == 1){
					validr1 = true;
				}
				else if(arr[row][col] == 2){
					validr2 = true;
				}
				else if(arr[row][col] == 3){
					validr3 = true;
				}
				else if(arr[row][col] == 4){
					validr4 = true;
				}
				else if(arr[row][col] == 5){
					validr5 = true;
				}
				else if(arr[row][col] == 6){
					validr6 = true;
				}
				else if(arr[row][col] == 7){
					validr7 = true;
				}
				else if(arr[row][col] == 8){
					validr8 = true;
				}
				else if(arr[row][col] == 9){
					validr9 = true;
				}
				else{
					return false;
				}
			}
			if(validr1 && validr2 && validr3 && validr4 && validr5 && validr6 && validr7 && validr8 && validr9){
				countValidRow++;
			}
		}
		
		
		
		if(countValid == 9 && countValidRow == 9){
			return true;
		}
		else{
			return false;
		}
	}
	
}