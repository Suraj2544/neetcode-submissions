class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int currentpoint=0;
        int Farthest=0;

        for(int i=0;i<nums.length-1;i++){
            Farthest=Math.max(Farthest,i+nums[i]);

            if(i==currentpoint){
                jump++;
                currentpoint=Farthest;
            }

            if(Farthest > nums.length -1) {
                break;
            }
        }
        return jump;
    }
}
