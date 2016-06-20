public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num)+1);
            }
        }

        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) >= 1){
               list.add(num);
               map.put(num, map.get(num)-1);
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for(Integer num : list){
            res[i] = num;
            i++;
        }
        return res;
    }
}
