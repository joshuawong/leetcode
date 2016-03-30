public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(res,"",0,0,n);
        return res;
    }
    
    private void backtracking(List<String> res, String cur, int open, int close, int max){
        // end condition: contains 3 pair of ()
        if(cur.length() == max * 2){
            res.add(cur);
            return;
        }
        

        if(close < open){
            backtracking(res,cur+')',open,close+1,max);
        }
        if(open < max){
            backtracking(res,cur+'(',open+1,close,max);
        }
    }
}
