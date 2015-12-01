class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.size();
        int m = needle.size();
        int index = -1;
        for (int i = 0; i <= n - m; ++i)
        {
        	if(needle.compare(haystack.substr(i,m)) == 0)
        		index = i;
        		break;
        }
        return index;
    }
};