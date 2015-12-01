class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int length = nums.size();
        vector<vector<int>> result;
        vector<int> tmp;

        int i, j, k;
        for(i = 0; i < length - 2; ) {

            j = i + 1;
            k = length - 1;

           for(; j < k; ) {

                tmp.clear();

                while(j < k) {
                    if(nums[j] + nums[k] == -nums[i])
                        break;
                    if(nums[j] + nums[k] > -nums[i])
                        k--;
                    if(nums[j] + nums[k] < -nums[i])
                        j++;
                }
                if(j >= k)
                    break;
                tmp.push_back(nums[i]);
                tmp.push_back(nums[j]);
                tmp.push_back(nums[k]);

                result.push_back(tmp);

                j++;
                while(j < k && nums[j] == nums[j - 1]) j++;

                k--;
                while(k > j && nums[k] == nums[k + 1]) k--;
            }

            i++;
            while(i < length && nums[i] == nums[i - 1]) i++;

        }

        return result;

    }
};