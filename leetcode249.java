public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String string : strings){
            int diff = string.charAt(0) - 'a';
            String tmp = "";
            for(int i = 0; i < string.length(); i++){
                char c = (char)(string.charAt(i) - diff);
                if(c < 'a')
                    c+=26;
                tmp+=c;
            }
            if(map.containsKey(tmp)){
                map.get(tmp).add(string);
            }
            else{
                List<String> list = new ArrayList<>();
                map.put(tmp, list);
                map.get(tmp).add(string);
            }
        }
        for(String key : map.keySet()){
            List<String> list = map.get(key);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}
