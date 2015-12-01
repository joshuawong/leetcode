class Stack {
private:
    queue<int> Q1;
    queue<int> Q2;
public:
    // Push element x onto stack.
    void push(int x) {
        Q1.push(x);
    }

    // Removes the element on top of the stack.
    void pop() {
        int n = Q1.size();
        for(int i = 0; i < n-1; ++i)
        {
            Q2.push(Q1.front());
            Q1.pop();
        }
        Q1.pop();
        while(!Q2.empty())
        {
            Q1.push(Q2.front());
            Q2.pop();
        }
    }

    // Get the top element.
    int top() {
        int res,n = Q1.size();
        for(int i = 0; i < n-1; ++i)
        {
            Q2.push(Q1.front());
            Q1.pop();
        }
        res = Q1.front();
        Q2.push(Q1.front());
        Q1.pop();
        while(!Q2.empty())
        {
            Q1.push(Q2.front());
            Q2.pop();
        }
        return res;
    }

    // Return whether the stack is empty.
    bool empty() {
        return Q1.empty();
    }
};