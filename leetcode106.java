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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(postorder.length-1, 0, inorder.length-1, inorder,postorder);
    }
    
    private TreeNode constructTree(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder){
        if(postEnd < 0 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == root.val){
                inIndex = i;
                break;
            }
        }
        root.left = constructTree(postEnd + inIndex - inEnd - 1, inStart, inIndex-1, inorder, postorder);
        root.right = constructTree(postEnd-1, inIndex+1,inEnd, inorder, postorder);
        return root;
    }
}
