public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] elements = new int[n];
        for(int i = 0;i < n; i++){
            for(int j = 0;j < words[i].length(); j++){
                elements[i] |= 1 << (words[i].charAt(j)-'a');  // record every letters in each word
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j< n;j++){
                if((elements[i] & elements[j]) == 0){
                    // words[i] and words[j] do not have same letter
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
