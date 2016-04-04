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
 Solution: In-order traversal
 Time: O(n)
 Space: O(n)
 */

 
public class Solution {
    private TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrderTraversal(root);
    }
    
    private boolean inOrderTraversal(TreeNode node){
        if(node == null)
            return true;
        if(inOrderTraversal(node.left)){
            if(prev != null && node.val <= prev.val)
                return false;
            prev = node;
            return inOrderTraversal(node.right);
        }
        return false;
    }
}
