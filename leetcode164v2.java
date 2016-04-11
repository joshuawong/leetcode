/*
Solution: Bucket sort
Reference: http://zkfairytale.blogspot.ca/2014/12/maximum-gap.html
*/

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // the minimum possible gap
        int gap = (int)Math.ceil((double)(max - min)/(nums.length-1));
        int[] bucketsMin = new int[nums.length-1]; // sort min value in this bucket
        int[] bucketsMax = new int[nums.length-1]; // sort max value in this bucket
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        // put numbers into buckets
        for(int num : nums){
            if(num == min || num == max)
                continue;
            int idx = (num - min) / gap;
            bucketsMin[idx] = Math.min(num, bucketsMin[idx]);
            bucketsMax[idx] = Math.max(num, bucketsMax[idx]);
        }
        
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i = 0; i < nums.length-1;i++){
            if(bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE)
                continue; // empty bucket 
            // min value minus the previous calue is the current gap
            maxGap = Math.max(maxGap, bucketsMin[i] - previous);
            previous = bucketsMax[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}
