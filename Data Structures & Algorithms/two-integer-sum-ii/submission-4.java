class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int i=0;
        int j=n-1;
        int[] result=new int[2];
        while(i<j){
            if(numbers[i] + numbers[j] < target){
                i++;
            }
            else if(numbers[i] + numbers[j] > target){
                j--;
            }
            else {
                result[0]=i+1;
                result[1]=j+1;
                return result;
            }
        }
        return new int[]{-1,-1};
    }
}
