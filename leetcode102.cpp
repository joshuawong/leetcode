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
    	vector<vector<int> > ret; 
    	void buildvector(TreeNode *root, int depth)
    	{
    		if(root == NULL)
    			return;
    		if(ret.size()== depth)
    			ret.push_back(vector<int>());
    		
    		ret[depth].push_back(root->val);
    		buildvector(root->left,depth+1);
    		buildvector(root->right,depth+1);
    	}
    
        vector<vector<int>> levelOrder(TreeNode* root) {
        	buildvector(root,0);
        	return ret;
        }
    };