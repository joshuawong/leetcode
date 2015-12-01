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
	void postorder(TreeNode* root, vector<int>& nodes)
	{
		if(!root) 
			return;
		postorder(root->left,nodes);
		postorder(root->right,nodes);
		nodes.push_back(root->val);
	}

    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        postorder(root,res);
        return res;
    }
};