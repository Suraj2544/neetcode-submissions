class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount =0;
        HashSet <Integer> set=new HashSet <>();
        for(int num : nums){
            set.add(num);
        }

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int count=1;
                while(set.contains(nums[i]+1)){
                    count++;
                    nums[i]++;
                }
                maxCount=Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
}
