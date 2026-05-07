class Solution {
    static int[] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        
        dp=new int[n];
        Arrays.fill(dp,-1);
        int ans1=loot(0,n-2,nums);

        dp=new int[n];
        Arrays.fill(dp,-1);
        int ans2=loot(1,n-1,nums);

        return Math.max(ans1,ans2);
    }

    private int loot(int i,int end,int[] nums){
        if(i > end){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int rob=nums[i]+loot(i+2,end,nums);
        int skip=loot(i+1,end,nums);

        return dp[i]=Math.max(rob,skip);
    }

}
