public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
      Map<Character, String> map = new HashMap<>();
      Set<String> set = new HashSet<>();

      return isMatch(map, set, str, 0, pattern, 0);
    }

    private boolean isMatch(Map<Character, String> map, Set<String> set, String str, int strIndex, String pattern, int patternIndex){
      if(strIndex == str.length() && patternIndex == pattern.length())
        return true;
      if(strIndex == str.length() || patternIndex == pattern.length())
        return false;

      char c = pattern.charAt(patternIndex);
      if(map.containsKey(c)){
        String tmp = map.get(c);

        if(!str.startsWith(tmp, strIndex)){
          return false;
        }

        return isMatch(map, set, str, strIndex+tmp.length(), pattern, patternIndex+1);
      }

      for(int i = strIndex; i < str.length(); i++){
        String tmp = str.substring(strIndex, i+1);
        if(set.contains(tmp))
          continue;

        map.put(c, tmp);
        set.add(tmp);

        if(isMatch(map,set,str,i+1, pattern, patternIndex+1)){
          return true;
        }

        map.remove(c);
        set.remove(tmp);
      }

      return false;
    }
}
