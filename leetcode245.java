public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int a = -1, b = -1, res = Integer.MAX_VALUE;
        if(word1.equals(word2)){
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    if(a == -1){
                        a = i;
                    }
                    else{
                        res = Math.min(res, i - a);
                        a = i;
                    }
                }
            }
        }
        else{
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1))
                    a = i;
                if(words[i].equals(word2))
                    b = i;
                if(a != -1 && b != -1)
                    res = Math.min(res, Math.abs(a - b));
            }
        }
        return res;
    }
}
