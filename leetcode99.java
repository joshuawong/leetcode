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
 Solution: use two pointer to find first and second nodes; nodes in in-order-traversal must be increased, thus,  nodes do not obey increasing order would be the node we are looking for. 
 */
public class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        inOrderCheck(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private void inOrderCheck(TreeNode root){
        if(root == null)
            return;
        inOrderCheck(root.left);
        if(first == null && prev.val >= root.val)
            first = prev;
        if(first != null && prev.val >= root.val)
            second = root;
        prev = root;
        inOrderCheck(root.right);
    }
}
