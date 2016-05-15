/*
Time: O(n), traverse string once
Space: O(1). size of chars is 128, so constant space
*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      int maxLen = 0;
      int l = 0, r = 0, count = 0;
      int[] chars = new int[128];
      while(r < s.length()){
        if(chars[s.charAt(r)] == 0){
          count++;
          while(l <= r && count > k){
            // remove element
            chars[s.charAt(l)]--;
            if(chars[s.charAt(l)] == 0){
              count--;
            }
            l++;
          }
        }
        chars[s.charAt(r)]++;
        r++;
        maxLen = Math.max(maxLen, r - l);
      }
      return maxLen;
    }
}
