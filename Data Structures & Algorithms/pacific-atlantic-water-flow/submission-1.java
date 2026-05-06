class Solution {
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific (top + left)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, 0);
        }

        // Atlantic (bottom + right)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j, 0);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        if (i < 0 || j < 0 || i >= m || j >= n
                || visited[i][j]
                || heights[i][j] < prevHeight) {
            return;
        }
        visited[i][j] = true;

        dfs(heights, visited, i + 1, j, heights[i][j]); // DOWN
        dfs(heights, visited, i - 1, j, heights[i][j]); // UP
        dfs(heights, visited, i, j + 1, heights[i][j]); // RIGHT
        dfs(heights, visited, i, j - 1, heights[i][j]); // LEFT
    }
}