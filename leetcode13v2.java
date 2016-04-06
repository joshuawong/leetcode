public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        char max = 'I';
        for(int i = s.length() - 1; i >= 0; i--){
            if(getValue(s.charAt(i)) >= getValue(max)){
                max = s.charAt(i);
                res += getValue(s.charAt(i));
            }
            else{
                res -= getValue(s.charAt(i));
            }
        }
        return res;
    }
    
    private int getValue(char a){
        switch(a){
			case 'I':return 1;
			case 'V':return 5;
    		case 'X':return 10;
    		case 'L':return 50;
    		case 'C':return 100;
    		case 'D':return 500;
    		case 'M':return 1000;
		}
		return 0;
    }
}
