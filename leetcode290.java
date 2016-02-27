public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length)
            return false;
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        for(Integer i = 0; i < words.length;i++){
            if(map1.put(pattern.charAt(i),i) != map2.put(words[i],i))
                return false;
            
            
        }
        return true;
    }
}
