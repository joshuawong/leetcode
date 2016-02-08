class Solution {
public:
	bool isValid(string str)
	{
		if(str[0] == '0' && str.size() > 1)
			return false;
		if(str.size() == 3)
			return str <= "255";
		if(str.size() > 3)
			return false;
		return true;
	}

    vector<string> restoreIpAddresses(string s) {
        vector<string> res;
        for(int i = 1; i <= 3; i++)
        {
        	for(int j = i+1; j<=i+3 && j<s.size();j++)
        	{
        		for(int k = j+1; k <=j+3 && k<s.size();k++)
        		{
        			string s1 = s.substr(0,i);
        			string s2 = s.substr(i,j-i);
        			string s3 = s.substr(j,k-j);
        			string s4 = s.substr(k,s.size()-k);
        			if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
        			{
        				string tmp = s1 + '.' + s2 + '.' + s3 + '.' + s4;
        				res.push_back(tmp);
        			}
        		}
        	}
        }
        return res;
    }
};