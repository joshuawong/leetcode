/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode cur = root;
        while(cur != null){
            if(cur.left != null){
                cur.left.next = (cur.right != null) ? cur.right : getNext(cur);
            }
            
            if(cur.right != null){
                cur.right.next = getNext(cur);
            }
            
            cur = cur.next;
        }
        
        connect(root.left);
        connect(root.right);
    }
    
    private TreeLinkNode getNext(TreeLinkNode root){
        TreeLinkNode tmp = root.next;
        while(tmp != null){
            if(tmp.left != null){
                return tmp.left;
            }
            if(tmp.right != null){
                return tmp.right;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
