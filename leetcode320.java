public class Solution {
    public List<String> generateAbbreviations(String word) {
      List<String> res = new ArrayList<>();
      int n = word.length();
      for(int len = 0; len <= n; len++){
        String size = Integer.toString(len);
        for(int i = 0; i < n; i++){
          String abbr = word.substring(0,i) + size + word.substring(i+len);
          res.add(abbr);
        }
      }
      return res;
    }
}
