public class Solution {
    public boolean isValidSudoku(char[][] board, int row, int col, int x) {
        for(int i = 0; i < 9;i++){
            if(board[i][col] - '1' == x)
                return false;
            if(board[row][i] - '1' == x)
                return false;
        }
        for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[row / 3 * 3 + i][col / 3 * 3 + j] - '1' == x)
					return false;
			}
		}
        return true;
    }
    
    public boolean solver(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(int k = 0; k < 9; k++){
                        if(isValidSudoku(board,i,j,k)){
                             board[i][j] = (char)(k+'1');
                        // System.out.println(board[i][j]);
                            if(solver(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public void solveSudoku(char[][] board) {
        solver(board);
    }
}
