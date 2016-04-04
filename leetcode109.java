/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode list;
    
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        list = head;
        return sortedListToBST(0,n-1);
    }
    
    private TreeNode sortedListToBST(int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = left;
        list = list.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        parent.right = right;
        return parent;
    }
}
