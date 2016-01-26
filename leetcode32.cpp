class Solution {
public:
    int longestValidParentheses(string s) {
    	if(s.size() < 2)
    		return 0;
        int res = 0;
        int i = 0;
        stack<int> tmp;
        tmp.push(-1);
        for (int i = 0; i < s.size(); ++i)
        {
        	int t = tmp.top();
        	if(t != -1 && s[i] == ')' && s[t] == '(')
        	{
        		tmp.pop();
        		res = max(res,i - tmp.top());
        	}
        	else
        		tmp.push(i);
        }
        return res;
    }
};
