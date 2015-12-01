//翻转法 三步翻转 时间复杂度O(n)
class Solution {
public:
	void reverse(vector<int>& nums,int from, int to)
	{
		while(from < to)
		{
			int tmp = nums[from];
			nums[from++] = nums[to];
			nums[to--] = tmp;
		}
	}

    void rotate(vector<int>& nums, int k) {
        int n  = nums.size();
        k = k % n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
};