class Solution {
    static int[] dp;
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return loot(0,nums);
    }
    private int loot(int i,int[] nums){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int rob=nums[i]+loot(i+2,nums);
        int skip=loot(i+1,nums);
        int ans=Math.max(rob,skip);
        dp[i]=ans;
        return ans;
    }
}
