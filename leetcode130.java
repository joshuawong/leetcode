public class Solution {
    public void dfs(char[][] board, int i, int j){
        int row = board.length;
        int col = board[0].length;
        if(i > 1 && board[i-1][j] == 'O'){
            board[i-1][j] = 'A';
            dfs(board,i-1,j);
        }
        if(i < row-1 && board[i+1][j] == 'O'){
            board[i+1][j] = 'A';
            dfs(board,i+1,j);
        }
        if(j > 1 && board[i][j-1] == 'O'){
            board[i][j-1] = 'A';
            dfs(board,i,j-1);
        }
        if(j < col-1 && board[i][j+1] == 'O'){
            board[i][j+1] = 'A';
            dfs(board,i,j+1);
        }
    }
    
    public void solve(char[][] board) {
        if(board.length < 3)
            return;
        if(board[0].length < 3)
            return;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O'){
                board[0][i] = 'A';
                dfs(board,0,i);
            }
            if (board[m-1][i] == 'O')
            {
                board[m-1][i] = 'A';
                dfs(board,m-1,i);
            }
        }
        for(int j = 1; j < m-1;j++){
            if (board[j][0] == 'O')
            {
                board[j][0] = 'A';
                dfs(board,j,0);
            }
            if (board[j][n-1] == 'O')
            {
                board[j][n-1] = 'A';
                dfs(board,j,n-1);
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O') 
                    board[i][j]='X';
                else if(board[i][j]=='A') 
                    board[i][j]='O';
            } 
        }
    }
}
