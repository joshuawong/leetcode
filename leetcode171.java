public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        for(int i = 0; i < len ; i++){
            res = res*26 + (int)(s.charAt(i)-'A'+1);
        }
        return res;
    }
}
