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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagTraverse(root,result,0);
        return result;
    }
    
    private void zigzagTraverse(TreeNode root, List<List<Integer>> res, int level){
        if(root == null)
            return;
        if(res.size() <= level){
            res.add(new LinkedList<Integer>());
        }
        
        List<Integer> curLevel = res.get(level);
        if(level % 2 == 0)
            curLevel.add(root.val);
        else
            curLevel.add(0,root.val);
        
        zigzagTraverse(root.left,res,level+1);
        zigzagTraverse(root.right,res,level+1);
    }
}
