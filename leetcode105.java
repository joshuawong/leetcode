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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(0,0,inorder.length - 1,preorder,inorder);
    }
    
    private TreeNode constructTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == root.val){
                inIndex = i;
            }
        }
        root.left = constructTree(preStart+1, inStart, inIndex-1,preorder,inorder);
        root.right = constructTree(preStart + inIndex - inStart +1, inIndex+1,inEnd,preorder,inorder);
        return root;
    }
}
