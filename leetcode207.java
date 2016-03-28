public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        			}
        		}
        	}
        }
        return numOfQueue == numCourses;
    }
}
