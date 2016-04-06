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
 Reference: https://leetcode.com/discuss/45399/my-java-solution-which-is-easy-to-understand
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            // one of these two nodes is root, the LCA must be root
            return root;
        }
        /*
        case 1: p and q both locate in left subtree, then right equals to null, and the result would be left;
        case 2: p and q both locate in right subtree, result will be right;
        case 3: p and q locate in different subsyree, so the LCA must be root
        */
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p, q);
        // case 3
        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
