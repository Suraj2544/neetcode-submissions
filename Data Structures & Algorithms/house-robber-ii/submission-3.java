class Solution {
    public int rob(int[] nums) {
       int n=nums.length;
        if(n<2){
            return nums[0];
        } 
        int[] skipLast=new int[n-1];
        int[] skipFirst=new int[n-1];
        for(int i=0;i<n-1;i++){
            skipLast[i]=nums[i];
            skipFirst[i]=nums[i+1];
        }
        int last=robHelp(skipLast);
        int first=robHelp(skipFirst);
        return Math.max(last,first);
    }
    private int robHelp(int[] nums){
        int n=nums.length;
        if(n<2){
            return nums[0];
        }
        int[] dp=new int[n+1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }
}
