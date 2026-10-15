class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new LinkedHashSet <>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
         int i = 0;

        for (int num : set) {
            nums[i++] = num;
        }

        return set.size();
    }
}