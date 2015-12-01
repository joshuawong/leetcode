class MinStack {
public:
    std::stack<int> stk;
    std::stack<int> min;
    void push(int x) {
        stk.push(x);
        if(min.empty() || (!min.empty() && x <= min.top()))
        	min.push(x);
    }

    void pop() {
        if(!stk.empty())
        {
        	if(stk.top() == min.top())
        		min.pop();

        	stk.pop();
        }
    }

    int top() {
        if(!stk.empty())
        	return stk.top();
    }

    int getMin() {
        if(!stk.empty())
        	return min.top();
    }
};