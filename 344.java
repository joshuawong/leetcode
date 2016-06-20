public class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left++;
            right--;
        }
        return new String(c);
    }
}
