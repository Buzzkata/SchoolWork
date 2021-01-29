//Bozhidar Stoyanov, 0353616
//Program that checks if a sudoku solution is valid using multithreading.

public class validateSudoku {

    public static void main(String[] args) throws InterruptedException{
				  
		int sudoku [][] = {{8, 1, 2, 7, 5, 3, 6, 4, 9}, 
						    {9, 4, 3, 6, 8, 2, 1, 7, 5},
						    {6, 7, 5, 4, 9, 1, 2, 8, 3},
						    {1, 5, 4, 2, 3, 7, 8, 9, 6},
						    {3, 6, 9, 8, 4, 5, 7, 2, 1},
						    {2, 8, 7, 1, 6, 9, 5, 3, 4},
						    {5, 2, 1, 9, 7, 4, 3, 6, 8},
						    {4, 3, 8, 5, 2, 6, 9, 1, 7},
						    {7, 9, 6, 3, 1, 8, 4, 5, 1}};

        validateSudoku vs = new validateSudoku();        
        boolean ans = vs.isValid(sudoku, 0, 0); 

        if (ans){
            System.out.println("Sudoku solution is valid.");
			System.out.println("Here is our solved sudoku:");
			System.out.println();
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
		} else{
            System.out.println("Sudoku solution is not valid,");
        }
		
	}
	
	boolean status = true;
	public boolean checkSlots(int sudoku[][], int row, int col, int n) throws InterruptedException{
		
		int rowBegin = (row/3)*3;
		int colBegin = (col/3)*3;

		Thread thr1 = new Thread(new Runnable(){
			public void run(){
				for (int c = 0; c < 9; ++c){
					if (sudoku[row][c] == n){
						status = false;
					}
				}
			}

		});
		thr1.start();

		Thread thr2 = new Thread(new Runnable(){
			public void run(){
				for (int x = 0; x < 9; ++x){
					if (sudoku[x][col] == n){
						status = false;
					}
				}
			}

		});
		thr2.start();

		Thread thr3 = new Thread(new Runnable(){
			public void run(){
				for (int k = rowBegin; k < (rowBegin + 3); ++k){
					for (int l = colBegin; l < (colBegin + 3); ++l){
						if (sudoku[k][l] == n)
							status = false;
					}
				}
			}
		});
		thr3.start();	
		thr1.join();
		thr2.join();
		thr3.join();

		return status;
	}
	
	public boolean isValid(int sudoku[][], int row, int col) throws InterruptedException{
        if(row < 9){
            if(sudoku[row][col] != 0){
                if(col < 8){
                    return isValid(sudoku, row, col+1);
                }
                else if(row < 8){
                    return isValid(sudoku, row+1, 0);
                }
                return true;
            }
            else{
                for(int i=1;i<=9;++i){
                    if(checkSlots(sudoku, row, col, i)){       
                        sudoku[row][col] = i;
                        if(col == 8){
                            if(isValid(sudoku, row+1, 0)){
                                return true;
                            }
                        }
                        else{
                            if(isValid(sudoku, row, col+1)){
                                return true;
                            }
                        }
                        sudoku[row][col] = 0;
                    }
                }
                return false;
            }
        }
        return true;
	}
	
}