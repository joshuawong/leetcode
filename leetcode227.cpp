class Solution {
public:
    int calculate(string s) {
        int res = 0;
        int num = 0;
        char sign = '+';
        int n = s.size();
        stack<int> nums;
        for (int i = 0; i < n; ++i)
        {
        	if(s[i] >= '0' && s[i] <= '9')
        		num = num * 10 + s[i] - '0';
        	if (!isdigit(s[i]) && !isspace(s[i]) || i == s.size()-1)
        	{
        		if(sign == '+')
        			nums.push(num);
        		else if(sign == '-')
        			nums.push(-num);
        		else
        		{
        			int tmp = 0;
        			if(sign == '*')
        				tmp = nums.top() * num;
        			else
        				tmp = nums.top() / num;
        			nums.pop();
        			nums.push(tmp);
        		}
        		sign = s[i];
        		num = 0;
        	}
        }
        while(!nums.empty())
        {
        	res += nums.top();
        	nums.pop();
        }
        return res;
    }
    
};
