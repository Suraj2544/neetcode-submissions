class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Long> seen = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long complement =(long) target - nums[i] - nums[j] - nums[k];
                    if (seen.contains(complement)) {
                        result.add(Arrays.asList(nums[i], nums[j],(int) complement, nums[k]));
                    }
                    seen.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(result);
    }
}