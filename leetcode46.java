public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res,new ArrayList<Integer>(), nums,0);
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, List<Integer> cur, int[] nums, int len){
        // end condition
        if(len == nums.length){
            res.add(new ArrayList(cur));
            return;
        }
        
        for(int i = 0; i <= len; i++){
            cur.add(i,nums[len]);
            backtracking(res,cur,nums,len+1);
            cur.remove(i);
        }
    }
}
