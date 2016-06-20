public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return null;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;

        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                order[index++] = i;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : map.get(cur)){
                if(--indegree[i] == 0){
                    q.offer(i);
                    order[index++] = i;
                }
            }
        }
        return (index == numCourses) ? order : new int[0];
    }
}
