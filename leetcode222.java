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
 Solution: According to defination of complete binary tree, if height(left) == height(right) => this tree is a full binary tree; else, recursively calculate the # of nodes
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int left = getLeft(root.left);
        int right = getRight(root.right);
/*        System.out.println(left);
        System.out.println(right);*/
        if(left == right){
            return (2<<(left)) - 1;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    private int getLeft(TreeNode root) {  
        if(root == null)
            return 0;
        int count = 0;  
        while(root.left!=null) {  
            root = root.left;  
            ++count;  
        }  
        return count+1;  
    }  
      
    private int getRight(TreeNode root) {  
        if(root == null)
            return 0;
        int count = 0;  
        while(root.right!=null) {  
            root = root.right;  
            ++count;  
        }  
        return count+1;  
    } 
    
}
