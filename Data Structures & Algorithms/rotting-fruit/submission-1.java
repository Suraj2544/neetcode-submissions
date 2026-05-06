class Solution {
    int m, n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];

                if (explore(grid, queue, i - 1, j)) freshCount--; // UP
                if (explore(grid, queue, i + 1, j)) freshCount--; // DOWN
                if (explore(grid, queue, i, j - 1)) freshCount--; // LEFT
                if (explore(grid, queue, i, j + 1)) freshCount--; // RIGHT
            }
        }

        return freshCount == 0 ? minutes - 1 : -1;
    }

    private boolean explore(int[][] grid, Queue<int[]> queue, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) {
            return false;
        }
        grid[i][j] = 2;
        queue.offer(new int[]{i, j});
        return true;
    }
}