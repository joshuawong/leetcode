class Solution {
public:
    string multiply(string num1, string num2) {
        if(num1 == "0" || num2 == "0")
        	return "0";
        int len1 = num1.size();
        int len2 = num2.size();
        vector<int> tmp(len1+len2,0);
        for (int i = 0; i < len1; ++i)
        {
        	for(int j = 0; j < len2; ++j)
        	{
        		tmp[i+j+1] += (num1[i]-'0') * (num2[j]-'0');
        	}
        }

        for(int i = len1+len2-1; i >= 0; --i)
        {
        	if (tmp[i] >= 10)
        	{
        		tmp[i-1] += tmp[i] / 10;
        		tmp[i] %= 10;
        	}
        }

        int k = 0;
        while(tmp[k] == 0)
        	k++;

        string res = "";
        while(k < len1+len2)
        {
        	res += (tmp[k]+'0');
        	k++;
        }
        return res;
    }
};
