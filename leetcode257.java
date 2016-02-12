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
    void treePaths(TreeNode* root,vector<string> &res,string t)
    {
        if(!root->left && !root->right)
        {
            res.push_back(t);
            return;
        }
        if(root->left)
            treePaths(root->left,res,t+"->"+to_string(root->left->val));
        if(root->right)
            treePaths(root->right,res,t+"->"+to_string(root->right->val));      
    }

    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> res;
        if(root == NULL)
            return res;
        treePaths(root,res,to_string(root->val));
        return res;
    }
};
