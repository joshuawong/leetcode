class Solution {
public:
	struct LinkedNode
	{
    	int val;
    	LinkedNode *next;
    	LinkedNode(int x = 0) : val(x), next(NULL) {}
}	;
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        int size = nums.size();
        if(size <= 1) 
        	return false;
        LinkedNode *nodes = new LinkedNode[size];
        for (int i = 0; i < size; ++i)
        {
        	int bucket = abs(nums[i]) % size;
        	LinkedNode *node = nodes[bucket].next;
        	while(node)
        	{
        		int j = node->val;
        		if(nums[i] == nums[j] && i - j <= k)
        			return true;
        		node = node->next;
        	}
        	node = nodes[bucket].next;
        	nodes[bucket].next = new LinkedNode(i);
        	nodes[bucket].next->next = node;
        }
        return false;
    }
};