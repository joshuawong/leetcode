public class Solution {
	public List<Integer> grayCode(int n){
//		List<List<String>> res = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		res.add(0);
		dfs(res, n, 0, 1<<n);
		return res;
		
	}
	
	private void dfs(List<Integer>res, int n, int cur, int size){
// 		end condition
		if(res.size() == size){
			return;
		}
// 		judgement
		for(int i = 0; i < n; i++){
			int mask = 1<<i;
			int el = (cur^mask);
			if(!res.contains(el)){
				res.add(el);
				dfs(res, n, el, size);
				if(res.size()==size)
				    return;
				// return to previous condition
				res.remove(new Integer(el));
			}
		}
	}
}
