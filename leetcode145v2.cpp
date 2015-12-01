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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> visit;
        TreeNode* cur = root;
        TreeNode* last = NULL;
        while(cur || !visit.empty())
        {
        	if(cur)
        	{
        		visit.push(cur);
        		cur = cur -> left;
        	} 
        	else
        	{
        		TreeNode* top = visit.top();
        		if(top->right && last!= top->right)
        			cur = top->right;
        		else
        		{
        			res.push_back(top->val);
        			last = top;
        			visit.pop();
        		}
        	}
        }
        return res;
    }
};