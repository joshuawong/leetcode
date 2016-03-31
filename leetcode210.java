public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] cnt = new int[numCourses];
        List<Integer>[] nextSet = new List[numCourses];

        for(int i = 0; i < numCourses; i++){
<<<<<<< HEAD
        	nextSet[i] = new ArrayLsit<>();
=======
        	nextSet[i] = new ArrayList<>();
>>>>>>> c05fb885d956522cebfc262181ea1369380b1c3b
        }

        for(int[] prerequisite : prerequisites){
        	cnt[prerequisite[0]]++;
        	nextSet[prerequisite[1]].add(prerequisite[0]);
        }

        Queue<Integer> leaves = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
        	if(cnt[i] == 0){
        		leaves.add(i);
        	}
        }

        for(int i = 0; i < numCourses; i++){
        	if(leaves.isEmpty()){
        		return new int[0];
        	}
        	int n = leaves.remove();
        	// int n = leaves.poll();
        	res[i] = n;
        	for(int next : nextSet[n]){
        		cnt[next]--;
        		if(cnt[next] == 0){
        			leaves.add(next);
        		}
        	}
        }
        return res;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> c05fb885d956522cebfc262181ea1369380b1c3b