public class Solution {
	private int getNum(int[][] board, int rows, int cols, int x, int y){
		int sum = 0;
		for(int i = x-1; i <= x+1; i++){
			for(int j = y-1; j <= y+1; j++){
				if(i == x && j == y)
					continue;
				if(i >= 0 && i < rows && j >= 0 && j < cols && (board[i][j] == 1 || board[i][j] == 2))
					sum++;
			}
		}
		return sum;
	}

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        if(rows == 0)
            return;
        int cols = board[0].length;
        if(cols == 0)
        	return;
        for(int i = 0; i < rows; i++){
        	for(int j = 0; j < cols; j++){
        		int sum = getNum(board,rows,cols,i,j);
        		if(sum == 2)
        			continue;
        		else if(sum == 3)
        			board[i][j] = board[i][j] == 0 ? 3 : 1;
        		else
        			board[i][j] = board[i][j] == 1? 2 : 0;
        	}
        }
        for(int i = 0; i < rows; i++){
        	for(int j = 0; j < cols; j++){
        		board[i][j] %= 2;
        	}
        }
    }
}
