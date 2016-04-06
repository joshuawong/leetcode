/*
Solution: hashmap
*/
public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // map all the num
        for(int num : nums){
            int count = map.containsKey(num) ? map.get(num) : 0;
            map.put(num,count+1);
        }
        // traverse to find the num only appear once
        for(int num : nums){
            if(map.get(num) == 1){
                return num;
            }
        }
        return 0;
    }
}
