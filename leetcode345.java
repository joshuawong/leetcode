public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() < 2)
            return s;
        String vowels = "aeiouAEIOU";
        char[] c = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            while(l < r && !vowels.contains(c[l]+"")){
                l++;
            }
            while(l < r && !vowels.contains(c[r]+"")){
                r--;
            }
            char tmp = c[l];
            c[l] = c[r];
            c[r] = tmp;
            l++;
            r--;
        }
        return new String(c);
    }
}
