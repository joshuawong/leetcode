/*
Solution: set
*/
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            // if num appear twice, remove it from set
            if(set.contains(num)){
                set.remove(num);
            }
            else{
            // if num did not appear before, add into set
            set.add(num);
            }
        }
        // only the number appear once will exist in set
        return set.iterator().next();
    }
}
