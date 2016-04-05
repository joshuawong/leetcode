public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> cur,int start, int n, int k){
        // end condition
        if(k == 0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i <= n; i++){
            cur.add(i);
            backtrack(res,cur,i+1,n,k-1);
            cur.remove(cur.size()-1);
        }
    }
}
