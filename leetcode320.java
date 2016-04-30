public class Solution {
    public List<String> generateAbbreviations(String word) {
      List<String> res = new ArrayList<>();
      int len = word.length();
      if(len == 0)
        res.add("");
      else
        res.add(String.valueOf(len));

      for(int i = 0; i < len; i++){
        String rightString = word.substring(i+1);
        List<String> rights = generateAbbreviations(rightString);
        for(String right : rights){
          String left;
          if(i == 0)
            left = "";
          else
            left = String.valueOf(i);

          String tmp = left + word.substring(i, i+1) + right;
          res.add(tmp);
        }
      }
      return res;
    }
}
