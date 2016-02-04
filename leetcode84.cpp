class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        heights.push_back(0);
        stack<int> stk;
        int n = heights.size();
        int maxArea = 0;
        int h,w;
        for (int i = 0; i < n; ++i)
        {
        	if(stk.empty() || heights[stk.top()] < heights[i])
        	{
        		stk.push(i);
        	}
        	else
        	{
        		while(!stk.empty() && heights[i] <= heights[stk.top()])
        		{
        			h = heights[stk.top()];
        			stk.pop();
        			w = stk.empty()? i: i - (stk.top()+1);
        			maxArea = max(maxArea, h*w);
        		}
        		stk.push(i);
        	}
        }
        return maxArea;
    }
};
