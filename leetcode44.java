public class Solution {
    public boolean isMatch(String s, String p) {
        int len_s = s.length();
        int len_p = p.length();
        if(len_s == 0 && len_p == 0)
        	return true;
        else if(len_s == 0)
        {
        	char[] pChar = p.toCharArray();
        	for(int i = 0;i < len_p;i++)
        	{
        		if(pChar[i] != '*')
        			return false;
        	}
        	return true;
        }
        else if(len_p == 0)
        	return false;
        else
        {
        	char[] sChar = s.toCharArray();
        	char[] pChar = p.toCharArray();
        	int i =0, j= 0;
        	int posOfStar = -1;
        	int posOfMatched = -1;
        	while(i < len_s)
        	{
        		if(j < len_p && (sChar[i] == pChar[j] || pChar[j] == '?'))
        		{
        			i++;
        			j++;
        		}
        		else if(j < len_p && pChar[j] == '*')
        		{
        			posOfMatched = i;
        			posOfStar = j;
        			j++;
        		}
        		else if(posOfStar != -1)
        		{
        			i = ++ posOfMatched;
        			j = posOfStar+1;
        		}
        		else
        			return false;
        	}
        	while(j < len_p && pChar[j] == '*')
        		++j;
        	if(j == len_p)
        		return true;
        	else
        		return false;
        }
    }
}
