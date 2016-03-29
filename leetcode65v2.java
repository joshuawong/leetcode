public class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        int n =s.length();
        // remove whitespace before number
        while(i < n && Character.isWhitespace(s.charAt(i)))
            i++;
        // plus or minus sign
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            i++;
        boolean isNumeric = false;
        while(i < n && Character.isDigit(s.charAt(i))){
            i++;
            isNumeric = true;
        }
        // decimal number
        if(i < n && s.charAt(i) == '.'){
            i++;
             while(i < n && Character.isDigit(s.charAt(i))){
                i++;
                isNumeric = true;
            }
        }
        // exponent number
        if(isNumeric && i < n && s.charAt(i) == 'e'){
            i++;
            isNumeric = false;
            if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
                i++;
            while(i < n && Character.isDigit(s.charAt(i))){
                i++;
                isNumeric = true;
            }
        }
        
        // remove whitespace after number
        while(i < n && Character.isWhitespace(s.charAt(i)))
            i++;
        return isNumeric && i == n;
    }
}
