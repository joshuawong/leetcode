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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
      List<Integer> res = new ArrayList<>();

      Stack<Integer> predecessor = new Stack<>();
      Stack<Integer> successor = new Stack<>();

      inorder(root,target,predecessor,false);
      inorder(root,target,successor,true);

      while(k > 0){
        if(predecessor.isEmpty())
          res.add(successor.pop());
        else if(successor.isEmpty())
          res.add(predecessor.pop());
        else if(Math.abs(predecessor.peek() - target) < Math.abs(successor.peek() - target))
          res.add(predecessor.pop());
        else
          res.add(successor.pop());
        k--;
      }
      return res;
    }

    private void inorder(TreeNode root, double target, Stack<Integer> stk, boolean reverse){
      if(root == null)
        return;
      inorder(reverse ? root.right : root.left, target, stk, reverse);
      if((reverse && root.val <= target) || (!reverse && root.val > target))
        return;
      stk.push(root.val);
      inorder(reverse ? root.left : root.right, target, stk, reverse);
    }
}
