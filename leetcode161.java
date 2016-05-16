/*
Time: O(n). one-pass
Space: O(1).
*/

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
      int sLen = s.length();
      int tLen = t.length();
      for(int i = 0; i < Math.min(sLen, tLen); i++){
        if(s.charAt(i) != t.charAt(i)){
          if(sLen == tLen){ // replace 1 char
            if(s.substring(i+1).equals(t.substring(i+1)))
              return true;
            else
              return false;
          }
          else if(sLen < tLen){ // delete 1 char from s
            if(s.substring(i).equals(t.substring(i+1)))
              return true;
            else
              return false;
          }
          else if(sLen > tLen){ // delete 1 char from t
            if(s.substring(i+1).equals(t.substring(i)))
              return true;
            else
              return false;
          }
        }
      }
      // delete the last char from s or t
      return Math.abs(sLen - tLen) == 1;
    }
}
