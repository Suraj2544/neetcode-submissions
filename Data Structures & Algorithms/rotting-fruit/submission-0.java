class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][] time=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                time[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    dfs(grid,time,i,j,0);
                }
            }
        }

        int minTime=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(time[i][j]==Integer.MAX_VALUE){return  -1;}

                    minTime=Math.max(minTime,time[i][j]);
                }
            }
        }
        return minTime;
        
    }
    private void dfs(int[][] grid,int [][] time,int i,int j,int currentTime){
        if(i<0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]==0 || currentTime > time[i][j] ){
            return;
        }
        time[i][j]=currentTime;
        dfs(grid,time,i-1,j,currentTime+1);
        dfs(grid,time,i+1,j,currentTime+1);
        dfs(grid,time,i,j-1,currentTime+1);
        dfs(grid,time,i,j+1,currentTime+1);
    }
}
