class Solution {
public:
    bool isValid(string s) {
       if(s.size() % 2 != 0)
       		return 0;

       	stack<char> stack;
       	int i = 0;
       	while(i < s.size())
       	{
       		if(stack.empty())
       			stack.push(s[i]);
       		else
       		{
       			if(stack.top() == '(' && s[i] == ')')
       				stack.pop();
       			else if(stack.top() == '[' && s[i] == ']')
       				stack.pop();
       			else if(stack.top() == '{' && s[i] == '}')
       				stack.pop();
       			else
       				stack.push(s[i]);
       		}	
       		i++;
       	} 
       	return stack.size() == 0;
    }
};