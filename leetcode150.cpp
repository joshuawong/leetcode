class Solution {
public:
	bool is_op(string str)
	{
		if(str == "+" || str == "-" ||str == "*" ||str == "/")
			return true;
		else
			return false;
	}

    int evalRPN(vector<string>& tokens) {
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        stack<int> stk;
        for (int i = 0; i < tokens.size(); ++i)
        {
        	if(is_op(tokens[i]) == false)
        		stk.push(atoi(tokens[i].c_str()));
        	else
        	{
        		num1 = stk.top();
        		stk.pop();
        		num2 = stk.top();
        		stk.pop();
        		res = 0;
        		switch(tokens[i][0])
        		{
        			case '+': res = num2 + num1; break;
        			case '-': res = num2 - num1; break;
        			case '*': res = num2 * num1; break;
        			case '/': if(num1 != 0) res = num2 / num1; break;
        		}
        		stk.push(res);
        	}
        }
        return stk.top();
    }
};
