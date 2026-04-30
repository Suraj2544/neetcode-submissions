class Solution {
    public int maxSubArray(int[] nums) {
        int MaxSum=nums[0];
        int sum=0;
        for(int num : nums){
            sum +=num;
            MaxSum= Math.max(sum,MaxSum);

            if(sum < 0){
                sum=0;
            }
        }
        return MaxSum;
    }
}
