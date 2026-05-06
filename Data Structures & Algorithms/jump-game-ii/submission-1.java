class Solution {
    public int jump(int[] nums) {
        int furthest=0;
        int currentmax=0;
        int jump=0;
        for(int i=0;i<nums.length-1;i++){
            furthest=Math.max(furthest,nums[i]+i);

            if(i==currentmax){
                jump++;
                currentmax=furthest;
            }

            if(furthest > nums.length-1){
                break;
            }
        }
        return jump;
    }
}
