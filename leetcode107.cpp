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
	vector<vector<int> > res;
	void helper(TreeNode *node, int height)
	{
		if(node == NULL)
			return;
		while(res.size() <= height)
			res.push_back(vector<int>());
		res[height].push_back(node->val);
		helper(node->left, height+1);
		helper(node->right, height+1);
	}

    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        helper(root,0);
        reverse(res.begin(), res.end());
        return res;
    }
};
