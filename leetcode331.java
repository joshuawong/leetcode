public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0)
            return false;
        String[] str = preorder.split(",");
        int depth = 0;
        int i = 0;
        while(i < str.length - 1){
            if(str[i].equals("#")){
                if(depth == 0)
                    return false;
                depth--;
                i++;
            }
            else{
                depth++;
                i++;
            }
                
        }
        if(depth != 0) 
            return false;
        return str[str.length - 1].equals("#");
    }
}
