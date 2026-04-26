class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0){
            return new int[0];
        }
        int n=numbers.length;
        int[] result=new int[2];
        int i=0;
        int j=n-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                return new int[]{i + 1, j + 1};
            }
            if(numbers[i]+numbers[j] < target){
                i++;
                continue;
            }
            if(numbers[i]+numbers[j] > target){
                j--;
                continue;
            }

        }
        return result;
    }
}
