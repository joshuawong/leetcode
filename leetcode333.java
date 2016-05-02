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
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(isValidBST(root, null, null))
            return countBST(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isValidBST(TreeNode root, Integer max, Integer min){
      if(root == null)
        return true;
      if(min != null && min >= root.val)
        return false;
      if(max != null && max <= root.val)
        return false;
      return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    private int countBST(TreeNode root){
      if(root == null)
        return 0;
      if(root.left == null && root.right == null)
        return 1;
      return 1 + countBST(root.left) + countBST(root.right);
    }
}
