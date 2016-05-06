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
Solution: DFS
Time: O(logn). traverse the given tree once. 
Space: O(1). does not create any space.
*/

public class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
    }

    private int dfs(TreeNode root, int count, int val){
        if(root == null)
            return count;
        if(root.val - val == 1)
            count++;
        else
            count = 1;

        int left = dfs(root.left, count, root.val);
        int right = dfs(root.right, count, root.val);
        return Math.max(Math.max(left, right), count);
    }
}
