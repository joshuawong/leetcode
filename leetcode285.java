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
Explanation:
        case 1: p.val >= root.val, so successor must in right subtree
        case 2: p.val < root.val, so successor must in left subtree
                if root have left subtree, return left child
                otherwise, the inorder-successor is parent of root
Time: O(logn). traverse the whole tree once.
Space: O(1).
*/
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;
        if(root.val <= p.val){
            return inorderSuccessor(root.right, p);
        }
        else{
          TreeNode left = inorderSuccessor(root.left,p);
          if(left == null)
            return root;
          else
            return left;
        }
    }
}
