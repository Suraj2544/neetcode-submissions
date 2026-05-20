class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet <List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                HashSet <Long> seen =new HashSet <>();
                for(int k=j+1;k<nums.length;k++){
                    long compliment = (long)target -nums[i]-nums[j]-nums[k];
                    if(seen.contains(compliment)){
                        result.add(Arrays.asList(nums[i],nums[j],(int)compliment,nums[k]));
                    }
                    seen.add((long)nums[k]);
                }
            }
        }
        return new ArrayList <>(result);
    }
}