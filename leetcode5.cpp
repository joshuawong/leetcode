class Solution {
public:
    string longestPalindrome(string s) {
    	int length = 1;
    	int start = 0;
        for (int i = 0; i < 2*s.size() -1; ++i)
        {
        	int begin = i / 2;
        	int end = i / 2;
        	if(i % 2 == 1)
        		end++;
        	while(begin >= 0 && end <= s.size() && s[begin] == s[end])
        	{
        		int count = end - begin + 1;
        		if(count > length)
        		{
        			length = count;
        			start = begin;
        		}
        		begin--;
        		end++;
        	}
        }
        return s.substr(start,length);
    }
};
