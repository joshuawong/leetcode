/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

 //BFS
class Solution {
public:
    int minDepth(TreeNode* root) {
        if(root == NULL)
        	return 0;
        queue<TreeNode*> Q;
        Q.push(root);
        int min = 0;
        while(!Q.empty())
        {
        	int size = Q.size();
        	min++;
        	for (int i = 0; i < size; ++i)
        	{
        		TreeNode *tmp = Q.front();
        		Q.pop();
        		if(tmp->left)
        			Q.push(tmp->left);
        		if(tmp->right)
        			Q.push(tmp->right);
        		if(tmp->left == NULL && tmp->right == NULL)
        			return min;
        	}
        }
    }
};