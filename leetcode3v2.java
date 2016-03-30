public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        for(int i = 0; i < s.length();i++){
            map[i] = -1;
        }
        int i = 0;
        int maxLen = 0;
        for(int j = 0; j < s.length();j++){
            if(map[s.charAt(j)] >= i){
                i = map[s.charAt(j)] + 1;
            }
            map[s.charAt(j)] = j;
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
