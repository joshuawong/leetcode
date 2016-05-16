/*
Solution: Bucket sort
Time: O(n).
Space: O(n).
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      int maxFrequency = 0;
      for(int num : nums){
        if(map.containsKey(num)){
          map.put(num, map.get(num)+1);
        }
        else{
          map.put(num, 1);
        }
        maxFrequency = Math.max(maxFrequency, map.get(num));
      }

      List<List<Integer>> bucket = new ArrayList<>(maxFrequency);
      while(maxFrequency-- >= 0){
        bucket.add(new ArrayList<>());
      }

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
          int frequency = entry.getValue();
          bucket.get(frequency).add(entry.getKey());
      }

      List<Integer> res = new ArrayList<>();
      for(int frequency = bucket.size() - 1; frequency >= 0 && res.size() < k; frequency--){
        res.addAll(bucket.get(frequency));
      }

      return res;
    }
}
