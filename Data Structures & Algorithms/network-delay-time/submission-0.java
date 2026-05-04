class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List <int []>> adj=new ArrayList <>();
        for(int i=0;i < n+1;i++){
            adj.add(new ArrayList <>());
        }

        for(int[] time : times){
            int u=time[0];
            int v=time[1];
            int t=time[2];

            adj.get(u).add(new int[]{v,t});
        } 
        PriorityQueue <int []> pq=new PriorityQueue <>((a,b)-> a[1]-b[1]);
        int[] dist=new int [n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k]=0;
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] node=pq.poll();
            int currNode=node[0];
            int currDist=node[1];
            if (currDist > dist[currNode]) continue; 
            for(int[] neighbour : adj.get(currNode)){
                int nextNode=neighbour[0];
                int nextDist=neighbour[1];

                int newDist=dist[currNode]+nextDist;
                if(newDist < dist[nextNode]){
                    dist[nextNode]=newDist;
                    pq.offer(new int[]{nextNode,newDist});
                }
            }
        }

            int maxVal = 0;
        for (int i = 1; i <= n; i++) { // Bug 4: was iterating from index 0 (unused), always hit MAX_VALUE
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxVal = Math.max(maxVal, dist[i]);
        }
        return maxVal;
    }
}
