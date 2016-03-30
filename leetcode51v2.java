public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] cur = new char[n][n];
        for(char[] row: cur){
            Arrays.fill(row,'.');
        }
        boolean[] col_occupied = new boolean[n];
        backtrack(res,cur,col_occupied,0,n);
        return res;
    }
    
    private void backtrack(List<List<String>> res, char[][] cur, boolean[] col_occupied, int r, int n){
        // end condition
        if(r == n){
            List<String> list = new ArrayList<>();
            for(char[] row: cur){
                list.add(new String(row));
            }
            res.add(list);
            return;
        }
        // judgement
        for(int i = 0; i < n; i++){
            if(isValid(cur,col_occupied,r,i,n)){
                cur[r][i] = 'Q';
                col_occupied[i] = true;
                // recursive
                backtrack(res,cur,col_occupied,r+1,n);
                // return to previous condition
                cur[r][i] = '.';
                col_occupied[i] = false;
            }
        }
    }
    
    private boolean isValid(char[][]curr, boolean[] col_occupied, int row, int col, int n) {
        if (col_occupied[col]) 
            return false;
        for (int i=1; row-i>=0 && col-i>=0; i++) {
            if (curr[row-i][col-i] == 'Q') 
                return false;
        }
        for (int i=1; row-i>=0 && col+i<n; i++) {
            if (curr[row-i][col+i] == 'Q') 
                return false;
        }
        return true;
}
}
