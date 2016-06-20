public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int cnt = numCourses;

        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : map.get(cur)){
                if(--indegree[i] == 0)
                    q.add(i);
            }
            cnt--;
        }
        return cnt == 0;
    }
}
