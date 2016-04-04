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
 Soultion: BFS
 Time: O(n)
 Space: O(n)
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode rightMost = root;
        int depth = 1;
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp.left == null && tmp.right == null)
                break;
            if(tmp.left != null)
                q.add(tmp.left);
            if(tmp.right != null)
                q.add(tmp.right);
            if(tmp == rightMost){
                depth++;
                rightMost = (tmp.right != null) ? tmp.right : tmp.left;
            }
        }
        return depth;
    }
}
