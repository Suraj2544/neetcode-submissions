class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList <>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList <>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited=new boolean [n];
        int components=0;

        for(int i=0;i<n;i++){
            if (visited[i]==false){
                components++;
                dfs(i,adj,visited);
            }
        }
        return components;


    }

    private void dfs(int i,List<List<Integer>> adj,boolean[] visited){
        visited[i]=true;

        for(int neighbour : adj.get(i)){
            if(visited[neighbour]==false){
                dfs(neighbour,adj,visited);
            }
        }
    }
}
