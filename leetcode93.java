public class Solution {
    private boolean isValid(String s)
    {
        char c = s.charAt(0);
        if(c == '0' && s.length() > 1)
            return false;
        if(s.length() == 3)
        {
            if(Integer.parseInt(s) <= 255)
                return true;
            else
                return false;
        }
        if(s.length() > 3)
            return false;
            
        return true;
    }
    
    public List<String> restoreIpAddresses(String s) {
        int size = s.length();
        List<String> res = new ArrayList();
        for(int i = 1;i <= 3; i++)
        {
            for(int j = i+1; j <= i+3 && j < size; ++j)
            {
                for(int k = j+1; k <= j+3 && k < size; ++k)
                {
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,size);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                    {
                        String tmp = s1 + '.' + s2 + '.' + s3 + '.' + s4;
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
}
