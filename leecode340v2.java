/*
Time: O(n). traverse string once.
Space: O(n). number of unique characters
*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      Map<Character, Integer> map = new HashMap<>();
      int j = 0, maxLen = 0;
      for(int i = 0; i < s.length(); i++){
        while(j < s.length() && map.size() <= k){
          if(map.containsKey(s.charAt(j))){
            map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
          }
          else{
            map.put(s.charAt(j),1);
          }
          if(map.size() <= k){
            maxLen = Math.max(maxLen, j - i + 1);
          }
          j++;
        }
        int count = map.get(s.charAt(i));
        if(count == 1){
          map.remove(s.charAt(i));
        }
        else{
          map.put(s.charAt(i), count - 1);
        }
      }
      return maxLen;
    }
}
