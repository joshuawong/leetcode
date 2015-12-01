class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int sum_miss = accumulate(nums.begin(), nums.end(), 0);
        int sum_all = (1+n)*n/2;
        return sum_all - sum_miss;
    }
};