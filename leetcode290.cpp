class Solution {
public:
    bool wordPattern(string pattern, string str) {
        map<char, string> mp1;
        map<string, char> mp2;

        vector<string> vec;
        int len = str.size();
        string word("");
        for (int i = 0; i < len; ++i)
        {
        	if(str[i] == ' ')
        	{
        		vec.push_back(word);
        		word = "";
        	}
        	else
        	{
        		word += str[i];
        	}
        	if(i == len -1)
        	{
        		vec.push_back(word); //push_back the last word
        	}
        }

        int n = pattern.size();
        if(vec.size() != n) return false;
        for (int i = 0; i < n; i++)
        {
        	map<char, string>::iterator mp1Ite;
        	map<string, char>::iterator mp2Ite;
        	mp1Ite = mp1.find(pattern[i]);
        	mp2Ite = mp2.find(vec[i]);
        	if(mp1Ite == mp1.end() && mp2Ite == mp2.end())
        	{
        		mp1[pattern[i]] = vec[i];
        		mp2[vec[i]] = pattern[i];
        	}
        	else if(mp1Ite != mp1.end() && mp2Ite != mp2.end())
        	{
        		if(mp1[pattern[i]] != vec[i] || mp2[vec[i]] != pattern[i])
        			return false;
        	}
        	else
        		return false;
        }
        return true;
    }
};