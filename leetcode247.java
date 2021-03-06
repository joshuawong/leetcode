/*
Solution: Recursion
*/
public class Solution {
    public List<String> findStrobogrammatic(int n) {
      List<String> res = new ArrayList<>();
      findRec(res, n, n);
      return res;
    }

    private void findRec(List<String> list, int n, int m){
      if(n == 0){
        list.add("");
        return;
      }
      if(n == 1){
        list.add("0");
        list.add("1");
        list.add("8");
        return;
      }
      findRec(list, n - 2, m);
      int size = list.size();
      int i = 0;
      while(i < size){
        String cur = list.get(i);
        if(n != m)
          list.add("0" + cur + "0");
        list.add("1" + cur + "1");
        list.add("6" + cur + "9");
        list.add("8" + cur + "8");
        list.add("9" + cur + "6");
        list.remove(0);
        size--;
      }
    }
}
