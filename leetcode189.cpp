//时间复杂度 O(kn) 暴力破解
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
   		int tmp = 0;
   		while(k--)
   		{
   			tmp = nums.back();
   			nums.pop_back();
   			nums.insert(nums.begin(),tmp);
   		}
    }
};