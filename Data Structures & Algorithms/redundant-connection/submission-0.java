class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++)
            parent[i] = i;                        // each node is its own parent initially

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1]))          // if union fails → already connected
                return edge;                       // this edge is redundant
        }

        return new int[]{};
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);          // path compression
        return parent[x];
    }

    private boolean union(int x, int y) {
        int px = find(x), py = find(y);

        if (px == py) return false;               // same component → cycle detected

        if (rank[px] > rank[py]) parent[py] = px;
        else if (rank[px] < rank[py]) parent[px] = py;
        else { parent[py] = px; rank[px]++; }    // union by rank

        return true;
    }
}