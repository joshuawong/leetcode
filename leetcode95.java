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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n == 0)
            return res;
        res = constructTree(1,n);
        return res;
    }
    
    private List<TreeNode> constructTree(int start, int end){
        List<TreeNode> trees = new ArrayList<>();
        if(start > end){
            trees.add(null);
            return trees;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> leftSubTrees = constructTree(start, i - 1);
            List<TreeNode> rightSubTrees = constructTree(i + 1, end);
            
            for(TreeNode leftSubTree : leftSubTrees){
                for(TreeNode rightSubTree : rightSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
