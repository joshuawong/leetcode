public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0)
            return false;

        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }

        boolean flag = false;
        for(int i = 0; i < 256; i++){
            if(count[i] % 2 != 0){
                if(flag == false)
                    flag = true;
                else
                    return false;
            }
        }
        return true;
    }
}
