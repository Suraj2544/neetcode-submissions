class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List <List <Integer>> adj =new ArrayList <>();
        int[] indegree=new int[numCourses];
        Queue <Integer> q=new LinkedList <>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList <>());
        }

        for(int[] pre : prerequisites){
            int a=pre[0];
            int b=pre[1];
            adj.get(a).add(b);
            indegree[b]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }
        return count==numCourses;
    }
}
