class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);  
            indegree[pre[0]]++;           
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) q.offer(i);

        int[] result = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            result[idx++] = node;
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) q.offer(neighbour);
            }
        }

        return idx == numCourses ? result : new int[]{};
    }
}