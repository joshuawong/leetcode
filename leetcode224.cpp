class Solution {
public:
    int calculate(string s) {
        int res = 0;
        int num = 0;
        int n = s.size();
        stack<int> nums,ops;
        int sign = 1;
        for(int i = 0; i < n; ++i)
        {
        	if(s[i] >= '0' && s[i] <= '9')
        		num = num * 10 + s[i] - '0';
        	else
            {
            	res += sign * num;
            	num = 0;
            	if(s[i] == '+')
            		sign = 1;
            	if(s[i] == '-')
            		sign = -1;
            	if(s[i] == '(')
            	{
            		nums.push(res);
            		ops.push(sign);
            		res = 0;
            		sign = 1;
            	}
            	if(s[i] == ')' && ops.size() != 0)
            	{
            		res = ops.top() * res + nums.top();
            		ops.pop();
            		nums.pop();
            	}
            }
        }
        res += sign * num;
        return res;
    }
};
