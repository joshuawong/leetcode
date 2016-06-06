public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> intersect = new ArrayList<>();
      for(int i = 0; i < nums1.length; i++){
        if(map.containsKey(nums1[i])){
          map.put(nums1[i], map.get(nums1[i])+1);
        }
        else{
          map.put(nums1[i], 1);
        }
      }

      for(int i = 0; i < nums2.length; i++){
        if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
            intersect.add(nums2[i]);
            map.put(nums2[i], map.get(nums2[i])-1);
        }
      }
      int[] result = new int[intersect.size()];
      int i = 0;
      for(Integer element : intersect){
        result[i] = element;
        i++;
      }

      return result;
    }
}
