class Solution {
public:
    char IntToChar(int n)
    {
        char res;
        res = n + 48;
        return res;
    }
    string countAndSay(int n) {
        if(n < 0) return "";
        if(n == 1) return "1";
        string result = countAndSay(n-1);
        int count = 1;
        string s = "";
        char tmp;
        for (int i = 0; i < result.size() - 1; ++i)
        {
        	if(result[i] == result[i+1])
        		count++;
        	else
        	{
        		tmp = IntToChar(count); 
        		s.push_back(tmp);
				s.push_back(result[i]);
        		count = 1;
        	}
        }
        return s;
    }
};