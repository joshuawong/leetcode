public class Solution {
    public static boolean isNumeric(String s)
    {
        return s.matches("[-+]?\\d*\\.?\\d+") || s.matches("[-+]?\\d+\\.?\\d*");
    }

    public static boolean isNumberInE1(String s)
    {
        return s.matches("[-+]?\\d*\\.?\\d+") || s.matches("[-+]?\\d+\\.?\\d*");
    }
    
    public static boolean isNumberInE2(String s)
    {
        return s.matches("[-+]?\\d+");
    }

    public boolean isNumber(String s) {
        s = s.replaceAll("\\s+$","");
        s = s.trim();
        if(isNumeric(s))
            return true;
        else if(s.indexOf('e') != -1)
        {
            int idx = s.indexOf('e');
            int len = s.length();
            String sub1 = s.substring(0,idx);
            String sub2 = s.substring(idx+1,len);
            if(isNumberInE1(sub1) && isNumberInE2(sub2))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
