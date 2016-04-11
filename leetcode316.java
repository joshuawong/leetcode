/*
Refernece: https://leetcode.com/discuss/73761/a-short-o-n-recursive-greedy-solution
Explaination: 1.count frequence of each letter
              2.find the leftmost and minimum appear once letter i, remove all the substring from begin to i, reduce the frequence of these removed letter in count arary.
              3.recursive the rest substring until the length of s equals to 0
*/
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++; // count the frequence 
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(pos)){
                pos = i;  // guarante the minimum number
            }
            if(--count[s.charAt(i) - 'a'] == 0)
                break; // guarante letter only appears once
        }
        if(s.length() == 0)
            return ""; // the length of s equals to 0, finish process
        else{
            return s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
            // recursive the substring, and remove pos letter from the rest substring
        }
    }
}
