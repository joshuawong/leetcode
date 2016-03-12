/*
Solution Method: Binary Search
*/
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        for(int i = nums.length - 1; i >= 0; i--){
            int index = findIndex(nums[i],list);
            ans[i] = index;
            list.add(index,nums[i]);
        }
        return Arrays.asList(ans);
    }
    
    private int findIndex(int target, List<Integer> list){
        if(list.size() == 0){
            return 0;
        }
        int start = 0;
        int end = list.size() - 1;
        if(list.get(end) < target){
            return end + 1;
        }
        if(list.get(start) >= target){
            return 0;
        }
        while(start+1 < end){
            int mid = start + (end - start) / 2;
            if(list.get(mid) < target){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        if(list.get(start) >= target){
            return start;
        }
        return end;
    }
}
