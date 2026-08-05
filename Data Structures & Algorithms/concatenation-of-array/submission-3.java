class Solution {
    public int[] getConcatenation(int[] nums) {
        int x=nums.length;
        int[] arr=new int[2*x];
        for (int i=0;i<nums.length;i++){
            arr[i]=nums[i];
            arr[i+x]=nums[i];
        }
        return arr;
    }
}