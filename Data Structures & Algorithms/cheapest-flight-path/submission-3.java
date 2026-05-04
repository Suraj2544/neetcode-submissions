class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges k+1 times (k stops = k+1 edges)
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n); // snapshot of current state

            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];

                if (dist[u] == Integer.MAX_VALUE) continue;

                if (dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}