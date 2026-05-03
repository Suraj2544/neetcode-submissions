class Solution {
    int m, n;

    public void islandsAndTreasure(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];

            explore(grid, queue, i + 1, j, grid[i][j]); // DOWN
            explore(grid, queue, i - 1, j, grid[i][j]); // UP
            explore(grid, queue, i, j + 1, grid[i][j]); // RIGHT
            explore(grid, queue, i, j - 1, grid[i][j]); // LEFT
        }
    }

    private void explore(int[][] grid, Queue<int[]> queue, int i, int j, int dist) {
        if (i < 0 || j < 0 || i >= m || j >= n
            || grid[i][j] != Integer.MAX_VALUE) {
            return;
        }
        grid[i][j] = dist + 1;
        queue.offer(new int[]{i, j});
    }
}