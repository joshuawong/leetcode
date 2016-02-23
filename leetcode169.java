//divide and conquer
public class Solution {
    public int majorityElement(int[] nums) {
    	return helper(nums,0,nums.length-1);
    }

    private int helper(int[] nums, int l, int r){
    	if(l == r)
    		return nums[l];
    	int m = (l+r)/2;
    	int a = helper(nums,l,m);
    	int b = helper(nums,m+1,r);

    	if(a == b)
    		return a;
    	int count1 = 0, count2 = 0;
    	for(int i = l; i <= r; i++){
    		if(nums[i] == a)
    			count1++;
    		else if(nums[i] == b)
    			count2++;
    	}
    	return count1 > count2 ? a : b;
    }
}
