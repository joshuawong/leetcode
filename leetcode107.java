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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root,res,0);
        Collections.reverse(res);
        return res;
        
    }
    
    public void helper(TreeNode node, List<List<Integer>> res,int height)
    {
        if(node == null)
            return;
        if(res.size() <= height)
        {
            res.add(new ArrayList<Integer>());
        }
        res.get(height).add(node.val);
        //res.get(height).add(node.val);
        helper(node.left,res,height+1);
        helper(node.right,res,height+1);
    }
}
