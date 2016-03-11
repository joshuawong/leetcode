public class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        placeQueens(new int[n],n,0,res);
        return res.size();
    }
    
        private boolean canPlaceQ(int[] tmp, int col){
        for(int i = 0; i < col; i++){
            if(tmp[i] == tmp[col] || (Math.abs(tmp[col] - tmp[i]) == Math.abs(col - i))){
                return false;
            }
        }
        return true;
    }
    
    private void placeQueens(int[] tmp, int n, int col, List<List<String>> res){
        if(col == n){
            ArrayList<String> temp = printResult(tmp,n);
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(tmp[col] = 0; tmp[col] < n; ++tmp[col]){
            if(canPlaceQ(tmp,col)){
                placeQueens(tmp,n,col+1,res);
            }
        }
            
    }
    
    private ArrayList<String> printResult(int[] pos, int n){
        ArrayList<String> ls = new ArrayList<String>();
        for(int i = 0; i < n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n-1; j++){
                sb.append('.');
            }
            sb.insert(pos[i],'Q');
            ls.add(sb.toString());
        }
        return ls;
    }
}
