import java.text.DecimalFormat;

public class sudokuValidate {

    public static void main(String[] args) throws Exception{

          int sudoku[][] = {{8, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 3, 6, 0, 0, 0, 0, 0},
                            {0, 7, 0, 0, 9, 0, 2, 0, 0},
                            {0, 5, 0, 0, 0, 7, 0, 0, 0},
                            {0, 0, 0, 0, 4, 5, 7, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 3, 0},
                            {0, 0, 1, 0, 0, 0, 0, 6, 8},
                            {0, 0, 8, 5, 0, 0, 0, 1, 0},
                            {0, 9, 0, 0, 0, 0, 4, 0, 0}};

        sudokuValidate m = new sudokuValidate();
        long starttime = System.nanoTime();
        boolean k = m.fillsudoku(sudoku, 0, 0);
        long endtime = System.nanoTime();

        DecimalFormat df = new DecimalFormat("#.##");

        if (k) {
            System.out.println("Answer found");
            System.out.println("Time elapsed = " + df.format((double) (endtime - starttime) / 1000000) + "ms");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Not found");
        }
    }

    public boolean fillsudoku(int sudoku[][], int row, int col){
        if(row < 9){
            if(sudoku[row][col] != 0){
                if(col < 8){
                    return fillsudoku(sudoku, row, col+1);
                }
                else if(row < 8){
                    return fillsudoku(sudoku, row+1, 0);
                }
                return true;
            }
            else{
                for(int i=1;i<=9;i++){
					try{
						if(isAvailable(sudoku, row, col, i)){        // <- checking function
							sudoku[row][col] = i;
							if(col == 8){
								if(fillsudoku(sudoku, row+1, 0)){
									return true;
								}
							}
							else{
								if(fillsudoku(sudoku, row, col+1)){
									return true;
								}
							}
							sudoku[row][col] = 0;
						}
                    }
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
                    
                }
                return false;
            }
        }
        return true;
    }
	
	
	boolean flag = true;
	public boolean isAvailable(int sudoku[][], int row, int col, int num) throws InterruptedException
	{
    
	

		int rowStart = (row / 3) * 3;
		int colStart = (col / 3) * 3;

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 9; ++i) {
					if (sudoku[row][i] == num) {
						flag = false;
					}
				}
			}

		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 9; ++i) {
					if (sudoku[i][col] == num) {
						flag = false;
					}
				}
			}

		});
		t2.start();
	
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				for (int i = rowStart; i < (rowStart + 3); ++i) {
					for (int j = colStart; j < (colStart + 3); ++j) {
						if (sudoku[i][j] == num){
							flag = false;
						}
					}
				}
			}
		});
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		return flag;
	
	}
		
	
}