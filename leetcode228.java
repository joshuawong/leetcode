public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 1){
            res.add(nums[0]+"");
            return res;
        }
        
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            while(i < nums.length-1 && (nums[i+1] - nums[i] == 1)){
                i++;
            }
            if(start != nums[i])
                res.add(start + "->" + nums[i]);
            else
                res.add(start + "");
        }
        return res;
    }
}
