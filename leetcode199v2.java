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
 Method: BFS
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        List<TreeNode> levelOrder = new ArrayList<TreeNode>();
        if(root == null)
            return res;
        levelOrder.add(root);
        while(!levelOrder.isEmpty()){
            int len = levelOrder.size();
           res.add(levelOrder.get(len - 1).val);  // add the last node of each level
            for(int i = 0; i < len; i++){
                //traverse level
                TreeNode node = levelOrder.remove(0);
                if(node.left != null)
                    levelOrder.add(node.left);
                if(node.right != null)
                    levelOrder.add(node.right);
               
            }
        }
        return res;
    }
}
