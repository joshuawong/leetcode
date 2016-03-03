/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 Method: DFS
 */
 
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        res.add(root.val);
        if(root.right != null)
            dfs(root.right,res,1);
        if(root.left != null)
            dfs(root.left,res,1);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> res, int height){
        if(height == res.size())
            res.add(root.val);
        if(root.right != null)
            dfs(root.right,res,height+1);
        if(root.left != null)
            dfs(root.left,res,height+1);
    }
}
