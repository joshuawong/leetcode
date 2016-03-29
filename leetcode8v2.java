/*
Solution: consider overflow situation
Time: O(n)
*/

public class Solution {
    private static final int maxDivTen = Integer.MAX_VALUE / 10;
    
    public int myAtoi(String str) {
        int i = 0;
        int n = str.length();
        int sign = 1;
        while(i < n && Character.isWhitespace(str.charAt(i)))
            i++;
        if(i < n && str.charAt(i) == '+')
            i++;
        else if(i < n && str.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        int num = 0;
        while(i < n && Character.isDigit(str.charAt(i))){
            int digit = Character.getNumericValue(str.charAt(i));
            if(num > maxDivTen || num == maxDivTen && digit >= 8){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }
}
