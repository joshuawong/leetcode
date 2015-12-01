class Solution {
public:
    string format(int begin, int end)
    {
        char buffer[32];
        if(end == begin)
        {
            sprintf(buffer,"%d",begin);
        }
        else
        {
            sprintf(buffer,"%d->%d",begin,end);
        }
        return string(buffer);
    }
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> result;
        if(nums.size() < 1)
            return result;
        int begin,end;
        begin = end = nums[0];
        for(int i = 1; i < nums.size(); ++i)
        {
            if(nums[i] == end || nums[i] == end+1)
            {
                end = nums[i];   
            }
            else
            {
                result.push_back(format(begin,end));
                begin = end = nums[i];
            }
        }
        result.push_back(format(begin,end));
        return result;
    }
};