class NumArray {
    vector<int> array = {0};
public:
    NumArray(vector<int> &nums) {
        int sum = 0;
        for(int i = 0; i < nums.size(); ++i)
        {
            sum += nums[i];
            array.push_back(sum);
        }
    }

    int sumRange(int i, int j) {
        return array[j+1] - array[i];
    }
};


// Your NumArray object will be instantiated and called as such:
// NumArray numArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
