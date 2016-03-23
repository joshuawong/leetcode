public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> path = new ArrayList<Integer>();
       backtrack(res,path,n,1,k);
       return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int target, int start, int k){
        if(target == 0 && k == 0){
            List<Integer> tmp = new ArrayList<Integer>(path);
            res.add(tmp);
            return;
        }
        for(int i = start; i <= 9 && i <= target; i++){
            path.add(i);
            backtrack(res,path,target-i,i+1,k-1);
            path.remove(path.size()-1);
        }
    }
}
