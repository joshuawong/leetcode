/*
Brute force solution
Time: O(n^2)
Space: O(1)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n;i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}*/
/*
Hash Table solution
Time: O(n)
Space: O(n)
*/
public class Solution{
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(map.containsKey(target - x)){
                return new int[] {map.get(target-x),i};
            }
            map.put(x,i);
        }
        return new int[]{0,0};
    }
}
