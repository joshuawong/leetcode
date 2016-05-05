/*
Solution: Stack
Explanation: 1 If current value is in left subtree, value < stk.peerk()
             2 If current value is in right subtree, value > stk.peek(), and
               pop all nodes from left subtree and root out of stack.
             3 Use a low flag to record the value, so that we can judge whether current
               value is from left subtree/root when traversing the right subtree.
Time: O(n). traverse int array once.
Space: O(n). stack size.
*/
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<>();
        for(int p : preorder){
            if(p < low)
                return false;
            while(!stk.isEmpty() && p > stk.peek()){
                // right subtree
                low = stk.pop();
            }
            stk.push(p);
        }
        return true;
    }
}
