class Solution {
    public void sortColors(int[] nums) {
        PriorityQueue <Integer> minHeap =new PriorityQueue <>();
        for(int num : nums){
            minHeap.add(num);
        }

        for(int i=0;i<nums.length;i++){
            nums[i]=minHeap.poll();
        }

    }
}