/*
Solution: bit manipulate
Explaination: number XOR itself equals to 0, the result will equals to the number only appear once
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }
}
