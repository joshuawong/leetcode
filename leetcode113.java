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
	public void pathSumHelper(TreeNode root, int sum,Stack<Integer> path,List<List<Integer>> res)
	{
		path.push(root.val);
		if(root.left == null && root.right == null)
		{
			if(sum == root.val)
			{
				List<Integer> tmp = new ArrayList<Integer>(path);
				res.add(tmp);
			}
		}
		if(root.left != null) 
			pathSumHelper(root.left,sum-root.val,path,res);
		if(root.right != null)
			pathSumHelper(root.right,sum-root.val,path,res);
		path.pop();
	}

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<Integer> path = new Stack<Integer>();
        if(root == null)
        	return res;
        pathSumHelper(root,sum,path,res);
        return res;
    }
}
