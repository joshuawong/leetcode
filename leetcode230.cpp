/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
	int count_size(TreeNode* root)
	{
		if(!root) 
			return 0;
		return 1+count_size(root->left) + count_size(root->right);
	}

    int kthSmallest(TreeNode* root, int k) {
        if(!root) 
        	return 0;
        if(k == 0)
        	return root->val;
        int n = count_size(root->left);
        if(k == n+1)
        	return root->val;
        if(k > n)
        	return kthSmallest(root->right,k-n-1);
        else
        	return kthSmallest(root->left,k);
    }
};
