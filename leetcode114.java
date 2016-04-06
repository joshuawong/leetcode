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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode cur = stk.pop();
            if(cur.right != null)
                stk.push(cur.right);
            if(cur.left != null)
                stk.push(cur.left);
            if(!stk.isEmpty())
                cur.right = stk.peek();
            cur.left = null;
        }
    }
}
