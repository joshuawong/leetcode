public class Solution {
    public List<String> generatePalindromes(String s) {
      int numberOfOdd = 0;
      String mid = "";
      Map<Character, Integer> map = new HashMap<>();
      List<String> res = new ArrayList<>();
      List<Character> list = new ArrayList<>();

      // count the number of odd
      for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        map.put(c, map.containsKey(c) ? map.get(c)+1 : 1);
        numberOfOdd += map.get(c) % 2 == 0 ? -1 : 1;
      }

      // number of odd more than 1, cannot generate palindrome
      if(numberOfOdd > 1)
        return res;

      for(Map.Entry<Character, Integer> entry : map.entrySet()){
        char key = entry.getKey();
        int value = entry.getValue();

        if(value % 2 != 0)
          mid += key;

        for(int i = 0; i < value / 2; i++)
          list.add(key);
      }
      getPermutation(list, mid, new boolean[list.size()], new StringBuilder(), res);

      return res;
    }

      private void getPermutation(List<Character> list, String mid, boolean[] visied, StringBuilder sb, List<String> res){
        if(sb.length() == list.size()){
          res.add(sb.toString() + mid + sb.reverse().toString());
          sb.reverse();
          return;
        }

        for(int i = 0; i < list.size(); i++){
          if(i > 0 && list.get(i) == list.get(i-1) && !visied[i-1])
            continue; // avoid duplication

          if(!visied[i]){
            visied[i] = true;
            sb.append(list.get(i));
            getPermutation(list, mid, visied, sb, res);

            visied[i] = false;
            sb.deleteCharAt(sb.length() - 1);
          }
        }
    }
}
