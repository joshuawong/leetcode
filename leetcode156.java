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
Explanation: 题意是说每个结点的右子树要么为空, 要么一定有一个左子树孩子和一个右子树孩子,
因此树的形状是左偏的. 所以我们要将最左边的子树作为最终的新根结点, 然后递归的将其父结点作为其右孩子,
并且父结点的右孩子作为其左孩子. 一个非常重要的地方是每次一定要将父结点的左右孩子都置为空,
因为父结点设置成其左孩子的右孩子之后成了叶子结点, 需要将其指针断掉.
root.left.left = root.right;   父结点的右孩子作为其左孩子
root.left.right = root;   父结点作为其右孩子

Solution: Bottom-up
Time: O(logn). the solution treaverse the tree once.
Space: O(logn). create logn new root nodes.
*/

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;

        TreeNode node = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return node;
    }
}
