class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int left=0;
        int sum=0;
        int minVal=Integer.MAX_VALUE;
        for(int right=0;right < n;right++){
            sum +=nums[right];

            while(sum >= target){
                int currentlength=right-left+1;
                minVal=Math.min(minVal,currentlength);
                sum -=nums[left];
                left++;
            }
        }
        return minVal==Integer.MAX_VALUE ? 0 : minVal;
    }
}