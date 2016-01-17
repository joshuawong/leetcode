class Solution {
public:
    void recursion(vector<int> nums, int begin,  vector<vector<int> > &res) {
        if (begin == nums.size() -1) {
            res.push_back(nums);
            return;
        }
        for (int i = begin; i < nums.size(); i++) {
            if (begin != i && nums[begin] == nums[i]) continue;
            swap(nums[begin], nums[i]);
            recursion(nums, begin+1, res);
        }
    }
    vector<vector<int> > permuteUnique(vector<int> &nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int> >res;
        recursion(nums, 0, res);
        return res;
    }
};
