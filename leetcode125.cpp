class Solution {
public:
    bool isPalindrome(string s) {
        if(s.empty())
        	return true;
        int index1 = 0;
        int index2 = s.size() - 1;
        while(index1 < index2)
        {
        	if(!(s[index1]>='0'&&s[index1]<='9'||s[index1]>='a'&&s[index1]<='z'||s[index1]>='A'&&s[index1]<='Z'))
        	{
        		index1++;
        		continue;
        	}
        	if(s[index1] >= 'A' && s[index1] <= 'Z')
        		s[index1] += 32;

        	if(!(s[index2]>='0'&&s[index2]<='9'||s[index2]>='a'&&s[index2]<='z'||s[index2]>='A'&&s[index2]<='Z'))
        	{
        		index2--;
        		continue;
        	}
        	if(s[index2] >= 'A' && s[index2] <= 'Z')
        		s[index2] += 32;

        	if(s[index1] != s[index2])
	        	return false;
        	else
        	{
        		index1++;
        		index2--;
        	}
        }
        return true;
    }
};