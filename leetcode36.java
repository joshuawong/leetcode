public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] block = new boolean[3][3][9];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    if(row[i][num] || col[j][num] || block[i/3][j/3][num]){
                        return false;
                    }
                    else{
                        row[i][num] = true;
                        col[j][num] = true;
                        block[i/3][j/3][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
