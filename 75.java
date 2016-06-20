public class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int num : nums){
          switch(num){
            case 0:
              red++;
              break;
            case 1:
              white++;
              break;
            case 2:
              blue++;
              break;
          }
        }
        int index;
        for(index = 0; index < red; index++)
          nums[index] = 0;
        for(; index < red + white; index++)
          nums[index] = 1;
        for(; index < nums.length; index++)
          nums[index] = 2;
    }
}
