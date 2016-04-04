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
 Solution: Bottom-up
 Time: O(n)
 Explaination: At each node, the possible maximum path could be one of these:
                        1. max(left subtree) + node.val
                        2. max(right subtree) + node.val
                        3. max(left subtree) + max(right subtree) + node.val
                        4. node.val
                the 1~3 possibilities can be simplified as max(left subtree) + max(right subtree) + node.val
 */
public class Solution {
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
    
    private int findMax(TreeNode node){
        if(node == null)
            return 0;
        int left = findMax(node.left);
        int right = findMax(node.right);
        maxSum = Math.max(node.val+left+right, maxSum);
        int res = node.val + Math.max(left, right);
        return res > 0 ? res : 0;
    }
}
