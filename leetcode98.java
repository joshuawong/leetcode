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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValid(TreeNode root, long minVal, long maxVal){
        if(root == null){
            return true;
        }
        if(root.val >= maxVal || root.val <= minVal){
            return false;
        }
        return isValid(root.left,minVal,root.val) && isValid(root.right,root.val,maxVal);
    }
}
