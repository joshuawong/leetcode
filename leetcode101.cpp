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
	bool mirror(TreeNode *a, TreeNode *b)
	{
		if(a && b)
			return a->val == b->val && mirror(a->left,b->right) && mirror(a->right, b->left);
		else
			return a == b;
	}


    bool isSymmetric(TreeNode* root) {
        return !root || mirror(root->left,root->right);
    }
};