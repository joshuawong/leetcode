public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return res;
        }
        Arrays.sort(strs);
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String tmp = new String(ch);
            
            if(!map.containsKey(tmp)){
                List<String> subRes = new ArrayList<>();
                subRes.add(strs[i]);
                map.put(tmp,subRes);
            }
            else{
                map.get(tmp).add(strs[i]);
            }
        }
        
        for(List<String> m : map.values()){
            res.add(m);
        }
        return res;
    }
}
