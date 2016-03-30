public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0)
            return false;
        Stack<String> stk = new Stack<>();
        String[] str = preorder.split(",");
        for(int i = 0; i < str.length; i++){
            String tmp = str[i];
            while(tmp.equals("#") && !stk.isEmpty() && stk.peek().equals("#")){
                stk.pop();
                if(stk.isEmpty())
                    return false;
                stk.pop();
            }
            stk.push(tmp);
        }
        return stk.size() == 1 && stk.peek().equals("#");
    }
}
