class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0, right = height.size() - 1;
        int max1 = 0;
        while(left < right && left >= 0 && right <= height.size()-1)
        {
        	max1 = max(max1,min(height[left],height[right]) * (right-left));
        	if(height[left] > height[right])
        	{
        		right--;
        	}
        	else
        	{
        		left++;
        	}
        }
        return max1;
    }
};
