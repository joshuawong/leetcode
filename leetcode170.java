public class TwoSum {
	Map<Integer, Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
	public void add(int number) {
		int count = map.containsKey(number) ? map.get(number) : 0;
		map.put(number, count + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			int num = entry.getKey();
			int y = value - num;
			if(y == num){
				if(entry.getValue() >= 2)
					return true;
				}
				else if(map.containsKey(y)){
					return true;
				}
			}
			return false;
		}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
