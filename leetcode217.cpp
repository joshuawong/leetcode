class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
      map<int, int> map;
      for (int i = 0; i < nums.size(); ++i)
      {
        if(map.find(nums[i]) != map.end())
          return true;
        else
          map.insert(make_pair(nums[i],1));
      }
      return false;
    }
};