/*
1. From end to the beginning, find the first in-order pair of numbers, which is nums[i] < nums[i+1]

2. From end to the beginning, find the first number j larger than nums[i], which is nums[i] < nums[j] 

3. swap nums[i] and nums[j]

4. reverse all the numbers after nums[i+1]

5. if step 1 can not find an i which satisfied nums[i] < nums[i+1], it means this order is the last permute of the array.
Thus, reverse all the numbers.
*/

class Solution {
public:

    static int cmp1(int a,int b)  
    {  
        return b>a;  
    } 

    void nextPermutation(vector<int>& nums) {
        int i;
        for (i = nums.size() - 2; i >= 0 ; --i)
        {
            if(nums[i] < nums[i+1])                 // find the first in-oder pair of numbers (step 1)
                break;
        }      
        if(i < 0)
        {
            sort(nums.begin(), nums.end());         // step 5
            return;
        }

        int j;
        for (j = nums.size() - 1; j > i; j--)  
        {
            if(nums[i] < nums[j])                   //find the first numbers larger than i (step 2)
                break;
        }
        swap(nums[i],nums[j]);                      //step 3
        sort(nums.begin()+i+1, nums.end(),cmp1);//step 4
    }
};
