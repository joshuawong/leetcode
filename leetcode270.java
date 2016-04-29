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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root != null){
            res = Math.abs(target - root.val) < Math.abs(target - res) ? root.val : res;
            if(res == target)
                return res;
            root = root.val < target ? root.right : root.left;
        }
        return res;
    }
}
