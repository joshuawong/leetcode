public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(res,new ArrayList<Integer>(), nums,used);
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] used){
        // end condition
        if(cur.size() == nums.length){
            res.add(new ArrayList(cur));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i])
                continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            used[i] = true;
            cur.add(nums[i]);
            backtracking(res,cur,nums,used);
            used[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}
