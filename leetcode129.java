/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        TreeNode res = new TreeNode(0);
        helper(root,0,res);
        return res.val;
    }
    
    public void helper(TreeNode root, int sum, TreeNode res)
    {
        if(root.left == null && root.right == null)
        {
            res.val += (sum * 10 + root.val);
            return;
        }
        if(root.left != null)
            helper(root.left,sum*10+root.val,res);
        if(root.right != null)
            helper(root.right,sum*10+root.val,res);
        return;
    }
}
