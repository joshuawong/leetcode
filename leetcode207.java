public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
<<<<<<< HEAD
    	if(prerequisites == null)
        	return false;

        int n = prerequisites.length;

        if(numCourses <= 0 || n == 0)
        	return true;

        Map<Integr,Set<Integer>> pre = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
        	pre.put(i,new HashSet<Integer>());
        }

        for(int[] prerequisite : prerequisites){
        	pre.get(prerequisite[0]).add(prerequisite[1]);
        }

        LinkedList<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
        	if(pre.get(i).size() == 0){
        		leaves.add(i);
        	}
        }

        while(leaves.size() != 0){
        	int top = leaves.remove();
        	for(int i = 0; i < numCourses;i++){
        		if(prerequisites[i][1] == top){
        			pre.get(prerequisites[i][0]).remove(top);
        			if(pre.get(prerequisites[i][0]).size() == 0){
        				leaves.add(prerequisites[i][0]);
=======
        if(prerequisites == null)
        	return false;

        int n = prerequisites.length;
        if(numCourses <= 0 || n == 0)
        	return true;

        int[] preCount = new int[numCourses];
        for(int i =  0; i < n; i++){
        	preCount[prerequisites[i][0]]++;
        }

        LinkedList<Integer> preQueue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
        	if(preCount[i] == 0){
        		preQueue.add(i);
        	}
        }

        int numOfQueue = preQueue.size();
        while(!preQueue.isEmpty()){
        	int top = preQueue.remove();
        	for(int i = 0; i < n; i++){
        		if(prerequisites[i][1] == top){
        			preCount[prerequisites[i][0]]--;
        			if(preCount[prerequisites[i][0]] == 0){
        				numOfQueue++;
        				preQueue.add(prerequisites[i][0]);
>>>>>>> c05fb885d956522cebfc262181ea1369380b1c3b
        			}
        		}
        	}
        }
<<<<<<< HEAD

        for(int i = 0; i < numCourses; i++){
        	if(pre.get(i).size() != 0)
        		return false;
        }
        return true;
	}
}
=======
        return numOfQueue == numCourses;
    }
}
>>>>>>> c05fb885d956522cebfc262181ea1369380b1c3b
