/*
Reference: https://leetcode.com/discuss/71455/java-very-straightforward-solution-detailed-explanation
*/

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for(int i = 1; i <= (len-1)/2; i++){
            if(num.charAt(0) == '0' && i >= 2)
                break;
            for(int j = i+1; len-j >= j-i && len - j >= i; j++){
                if(num.charAt(i) == '0' && j-i >= 2)
                    break;
                
                long num1 = Long.parseLong(num.substring(0,i)); //num1
                long num2 = Long.parseLong(num.substring(i,j)); //num2
                String substr = num.substring(j); //rest
                
                if(isAdditive(substr, num1, num2))
                    return true;
            }
        }
        return false;
    }
    
    private boolean isAdditive(String str, long a, long b){
        if(str.equals(""))
            return true; //reach the end of string
        long sum = a + b;
        String s = ((Long)sum).toString();
        if(!str.startsWith(s))
            return false;
        return isAdditive(str.substring(s.length()), b, sum);
    }
}
