public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for(int i = 1; i <= nums.length; i++){
            dfs(new ArrayList<Integer>(), nums, i, 0, res);
        }
        return res;
    }
    
    private void dfs(List<Integer> cur, int[] nums,int len, int start, List<List<Integer>> res){
        if(cur.size() >= len){
            // end condition
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        // judgement
        for(int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            // recursive
            dfs(cur, nums, len,i+1, res);
            // return previous condition
            cur.remove(cur.size() - 1);
        }
    }
}
