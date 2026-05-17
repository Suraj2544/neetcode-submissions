class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) {
            map.add(num);
        }

        // Start from 1 (first positive), go up to n+1
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!map.contains(i)) {
                return i;
            }
        }

        return -1; // unreachable, but required for compilation
    }
}