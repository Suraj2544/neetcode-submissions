class Solution {
    public boolean validTree(int n, int[][] edges) {
        List <List <Integer>> adj =new ArrayList <>();
        if (edges.length != n - 1) return false;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList <>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited =new boolean [n];
        int count=1;
        Queue <Integer> q=new LinkedList <>();
        q.offer(0);
        visited[0]=true;

        while(!q.isEmpty()){
            int node=q.poll();
            for(int neighbour : adj.get(node)){
                if(visited[neighbour]==false){
                    visited[neighbour]=true;
                    q.offer(neighbour);
                    count++;
                }
            }
        }
        return count==n;

    }
}
