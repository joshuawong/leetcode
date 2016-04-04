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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        if(left == -1)
            return -1;
        int right = maxDepth(root.right);
        if(right == -1)
            return -1;
        return (Math.abs(left - right) <= 1) ? (Math.max(left,right) + 1) : -1;
    }
}
