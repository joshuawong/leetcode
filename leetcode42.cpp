class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0, right = height.size() - 1;
        int level = 0;
        int res = 0;
        while(left < right)
        {
        	int bound = height[height[left] < height[right]?left++:right--];
        	level = max(level,bound);
        	res += level - bound;
        }
        return res;
    }
};
