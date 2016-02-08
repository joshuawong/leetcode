class Solution {
public:
    bool wordBreak(string s, unordered_set<string>& wordDict) {
        vector<bool> words(s.size()+1,false);
        words[0] = true;
        for (int i = 0; i < s.size()+1; ++i)
        {
        	for(int j = i-1; j >= 0; --j)
        	{
        		if(words[j] == true && wordDict.find(s.substr(j,i-j)) != wordDict.end())
        		{
        			words[i] = true;
        			break;
        		}
        	}
        }
        return words[s.size()]
    }
};
