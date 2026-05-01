class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        StringBuilder a=new StringBuilder(word1);
        StringBuilder b=new StringBuilder(word2);
        return helper(m-1,n-1,a,b,dp);
    }

    private int helper(int i,int j,StringBuilder a, StringBuilder b,int[][] dp){
        if(i < 0){
            return j+1;
        }
        if(j < 0){
            return i+1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(a.charAt(i)==b.charAt(j)){
            return helper(i-1,j-1,a,b,dp);
        }
        int replace = 1 + helper(i-1, j-1, a, b, dp);  // match i with j → replace
        int delete  = 1 + helper(i-1, j,   a, b, dp);  // delete char from word1
        int insert  = 1 + helper(i,   j-1, a, b, dp);  // insert char into word1

        return dp[i][j]=Math.min(replace,Math.min(delete,insert));
    }
}
