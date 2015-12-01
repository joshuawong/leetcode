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
	void preorder(TreeNode* root, vector<int>& nodes)
	{
		if(!root) 
			return;
		nodes.push_back(root->val);
		preorder(root->left,nodes);
		preorder(root->right,nodes);
	}

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        preorder(root,res);
        return res;
    }
};