/*
Solution: Heap + HashMap
Time: O(n)
Space: O(n)
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> res = new ArrayList<>();
      for(int num : nums){
        if(map.containsKey(num)){
          map.put(num, map.get(num)+1);
        }
        else{
          map.put(num, 1);
        }
      }

      PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((o1,o2) -> o2.getValue() - o1.getValue());
      q.addAll(map.entrySet());
      for(int i = 0; i < k; i++){
        res.add(q.poll().getKey());
      }
      return res;
    }
}
